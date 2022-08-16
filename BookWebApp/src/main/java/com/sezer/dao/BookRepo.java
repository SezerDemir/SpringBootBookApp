package com.sezer.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.sezer.model.Book;

public interface BookRepo extends CrudRepository<Book, Integer>
{
	default ArrayList<Book> getBooks() {
	    final ArrayList<Book> books = new ArrayList<>();
	
	    Iterable<Book> iterable = findAll();
	    iterable.forEach(books::add);
	
	    return books;
	}
}
