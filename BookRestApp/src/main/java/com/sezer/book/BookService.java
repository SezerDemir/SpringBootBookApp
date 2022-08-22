package com.sezer.book;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService {
	
	private final BookRepository bookRepo;
	
	public List<Book> getBooks(int pageIndex) {
		PageRequest pr = PageRequest.of(pageIndex, 10);
		return bookRepo.findAll(pr).getContent();
	}
	
	public List<Book> getBooksByTimeFilter(LocalDate date) {
		return bookRepo.findByDateFilter(date).get();
	}
	
	public Book addBook(Book book) {
		if(book.getName() == null || book.getName().trim().equals(""))
			throw new IllegalArgumentException("invalid book object");
		return bookRepo.save(book);
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
