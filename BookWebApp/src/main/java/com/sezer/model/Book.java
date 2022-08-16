package com.sezer.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book 
{
	@Id
	private int id;
	private String name;
	
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
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "--Book-- id:" + id + " Name:" + name;
	}
	
}
