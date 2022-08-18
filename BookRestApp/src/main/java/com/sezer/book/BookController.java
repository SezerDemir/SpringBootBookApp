package com.sezer.book;

import java.time.LocalDate;
import java.util.List;

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

@RestController
@RequestMapping(path = "api/book")
@AllArgsConstructor
public class BookController {

	private final BookService bookService;
	
	@GetMapping(value="/get")
	public List<Book> getBooks(@RequestParam(name="index") int index)
	{
		return bookService.getBooks(index);
	}
	
	@GetMapping(value="/getByTimeFilter/{date}")
	public List<Book> getBookByTimeFilter(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date)
	{
		System.out.println(date);
		return bookService.getBooksByTimeFilter(date);
	}
	
	@PostMapping(value="/add")
	public Book addNewBook(@RequestBody Book book)
	{
		Book addedBook = bookService.addBook(book);
		return addedBook;
	}
	
	@DeleteMapping(path="/delete/{bookId}")
	public void removeBook(@PathVariable("bookId") int id)
	{
		bookService.removeBook(id);
	}
	
	@PutMapping(value="/update")
	public Book updateBook(@RequestBody Book book)
	{
		return bookService.updateBook(book);
	}
	


}
