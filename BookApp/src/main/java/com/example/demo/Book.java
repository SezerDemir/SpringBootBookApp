package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Book {
	private String name;
	private long id;
	
	public Book() {
		this.name = null;
		this.id = -1;
	}
	
	public Book(String name, long id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String toString() {
		if(name != null)
			return "id:" + id + " name:"+ name;
		else
			return "Not initialized Book object";
	}
}
