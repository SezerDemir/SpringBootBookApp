package com.sezer.book;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService {
	
	private final BookRepo bookRepo;
	
	public List<Book> getBooks()
	{
		return bookRepo.findAll();
	}
	
	public Book addBook(Book book)
	{
		if(book.getName() == null || book.getName().trim().equals("") || book.getPublishDate() == null)
			throw new IllegalArgumentException("invalid book object");
		bookRepo.save(book);
		return bookRepo.findByName(book.getName()).get();
	}
	
	public void removeBook(int id)
	{
		if(bookRepo.existsById(id))
			bookRepo.deleteById(id);
		else
			throw new IllegalArgumentException("id is not exist in the database");
	}
	
	public void updateBook(Book book)
	{
		if(book == null || !bookRepo.existsById(book.getId()))
			throw new IllegalArgumentException("there is no such a book in the database");
		else
			bookRepo.save(book);
	}
}