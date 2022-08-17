package com.sezer.book;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	@Id
	@SequenceGenerator(
			name = "book_sequence",
			sequenceName = "book_sequence",
			allocationSize  = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "book_sequence"
	)
	
	private Integer id;
	private String name;
	private LocalDate publishDate;
	
	public Book(String name, LocalDate publishDate)
	{
		this.name = name;
		this.publishDate = publishDate;
	}
	
	public String toString()
	{
		return "id:" + id + " name:" + name + " PublishDate:" + publishDate; 
	}
}
