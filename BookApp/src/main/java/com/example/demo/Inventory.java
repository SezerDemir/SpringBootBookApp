package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Inventory {
	
	private ArrayList<Book> books;
	
	public Inventory() {
		books = new ArrayList<Book>();
	}
	
	public ArrayList<Book> getBooks() {
		return books;
	}
	
	public void addBook(Book book) {
		if(book != null )
			books.add(book);
		else
			throw new IllegalArgumentException();
	}
	
	public void removeBook(long id) {
		for(Book book: books)
		{
			if(book.getId() == id)
			{
				books.remove(book);
				return;
			}
		}
	}
	
	public void printInventory() {
		for(Book book: books)
			System.out.println(book);
	}
}
