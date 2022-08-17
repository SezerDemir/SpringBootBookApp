package com.sezer.book;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "api/book")
@AllArgsConstructor
public class BookController {

	private final BookService bookService;
		
	
	@GetMapping(value="/getBooks")
	public List<Book> home()
	{
		return bookService.getBooks();
	}
	
	@PostMapping
	public void addNewBook(@RequestBody Book book)
	{
		bookService.addBook(book);
	}
	
	@DeleteMapping(path="{bookId}")
	public void removeBook(@PathVariable("bookId") int id)
	{
		bookService.removeBook(id);
	}
	
	@PostMapping(value="/updateBook")
	public void updateBook(@RequestBody Book book)
	{
		bookService.updateBook(book);
	}

}
