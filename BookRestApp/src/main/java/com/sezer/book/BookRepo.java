package com.sezer.book;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{
	
	@Query("SELECT b FROM Book b WHERE b.name= :name")
	Optional<Book> findByName(@Param("name") String name);
	
	@Query("SELECT b FROM Book b WHERE b.publishDate > :publish_date")
	Optional<List<Book>> findByDateFilter(@Param("publish_date") LocalDate localDate);
}
