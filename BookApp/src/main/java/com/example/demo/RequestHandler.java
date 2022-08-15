package com.example.demo;

import java.util.UUID;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class RequestHandler {
	ConfigurableApplicationContext context;
	@Autowired
	private Inventory inventory;
	
	public RequestHandler(ConfigurableApplicationContext context) {
		this.context = context;
	}
	
	public void addBookRequest(String name) {
		long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
		inventory.addBook(context.getBean(Book.class, name, id));
	}

	public void printBooksRequest()
	{
		inventory.printInventory();
	}
	

}
