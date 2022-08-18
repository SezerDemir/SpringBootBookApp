package com.sezer.book;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "publish_date" , nullable = false, updatable = false)
    @CreationTimestamp
	private LocalDate publishDate;
	
	public Book(String name)
	{
		this.name = name;
	}
	
	
	public String toString()
	{
		return "id:" + id + " name:" + name + " PublishDate:" + publishDate; 
	}
}
