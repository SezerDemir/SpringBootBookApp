package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BookApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BookApp.class, args);
		
		
		RequestHandler request_handler = context.getBean(RequestHandler.class);
		request_handler.addBookRequest("Lord of the Rings");
		request_handler.addBookRequest("The Hobbit");
		request_handler.addBookRequest("Game of Thrones");
		
		System.out.println("-----------");
		request_handler.printBooksRequest();
	}

}
