package com.sezer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	@Column(name = "name")
	private String book_name;
	
	public Book()
	{
		
	}
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName() 
	{
		return book_name;
	}

	public void setName(String book_name)
	{
		this.book_name = book_name;
	}

	@Override
	public String toString()
	{
		return "--Book-- id:" + id + " Name:" + book_name;
	}
	
}
