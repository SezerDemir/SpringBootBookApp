package com.sezer.book;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@Data
@RequestMapping(path = "api/book")
@AllArgsConstructor
public class BookController {

	private final BookService bookService;
	private final BookMapper bookMapper;
	
	@GetMapping(value="/get")
	public List<BookDTO> getBooks(@RequestParam(name="index") int pageIndex) {
		return bookService.getBooks(pageIndex).stream().
				map(b -> bookMapper.bookToBookDTO(b)).
				collect(Collectors.toList());
	}
	
	@GetMapping(value="/getByTimeFilter/{date}")
	public List<Book> getBookByTimeFilter(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		return bookService.getBooksByTimeFilter(date);
		
	}
	
	@PostMapping(value="/add")
	public BookDTO addNewBook(@RequestBody Book book) {
		return bookMapper.bookToBookDTO(bookService.addBook(book));
	}
	
	@DeleteMapping(path="/delete/{bookId}")
	public void removeBook(@PathVariable("bookId") int id) {
		bookService.removeBook(id);
	}
	
	@PutMapping(value="/update")
	public BookDTO updateBook(@RequestBody Book book) {
		//TODO returns null for publish field
		return bookMapper.bookToBookDTO(bookService.updateBook(book));
	}
	
}
