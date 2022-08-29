package com.sezer.book;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class BookService {
	
	private final BookRepository bookRepo;
	private final RestTemplate restTemplate;
	private final String baseUrl = "https://openlibrary.org/api/books?bibkeys=ISBN:";
	private final String optionParam = "&format=json&jscmd=data";
	
	public List<Book> getBooks(int pageIndex) {
		return bookRepo.findAll(PageRequest.of(pageIndex, 10)).getContent();
	}
	
	public List<Book> getBooksByTimeFilter(LocalDate date) {
		return bookRepo.findByDateFilter(date).get();
	}
	
	public Book addBook(BookDTO book) throws JsonProcessingException {
		String resourceUrl = baseUrl + book.getISBN() + optionParam;
		String jsonString = restTemplate.getForObject(resourceUrl, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(jsonString);
		Book newBook = mapper.treeToValue(root.elements().next(), Book.class);
		newBook.setIsbn(book.getISBN());
		return bookRepo.save(newBook);
	}
	
	public void removeBook(int id) {
		if(bookRepo.existsById(id))
			bookRepo.deleteById(id);
		else
			throw new IllegalArgumentException("id is not exist in the database");
	}
	
	public Book updateBook(Book book) {
		if(book == null || !bookRepo.existsById(book.getId()))
			throw new IllegalArgumentException("there is no such a book in the database");
		else
			return bookRepo.save(book);
	}
}
