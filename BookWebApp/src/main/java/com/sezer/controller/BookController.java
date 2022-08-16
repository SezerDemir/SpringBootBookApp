package com.sezer.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sezer.dao.BookRepo;
import com.sezer.model.Book;

@Controller
public class BookController 
{
	@Autowired
	BookRepo book_repo;
	
	@RequestMapping("/")
	public String home(ModelAndView mv)
	{
		return "home.jsp";
	}
	
	@RequestMapping("/addBook")
	public String addBookOperation(Book book)
	{
		book_repo.save(book);
		
		printBooks();
		
		return "home.jsp";
	}
	
	@RequestMapping("/removeBook")
	public String removeBookOperation(int id)
	{
		book_repo.deleteById(id);
		
		printBooks();
		
		return "home.jsp";
	}
	
	@RequestMapping("/updateBook")
	public String updateBookOperation(Book entity)
	{
		Book book = book_repo.findById(entity.getId()).get();
		book.setName(entity.getName());
		book_repo.save(book);
		
		printBooks();
		
		return "home.jsp";
	}
	
	@RequestMapping("/readBook")
	public String readBookOperation(Book entity)
	{
		Book book = book_repo.findById(entity.getId()).get();
		System.out.println(book);
		
		return "home.jsp";
	}
	
	
	private void printBooks()
	{
		ArrayList<Book> books = book_repo.getBooks();
		
		for(Book entity: books) 
		{
			System.out.println(entity);
		}
	}
}
