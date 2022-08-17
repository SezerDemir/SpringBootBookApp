package com.sezer.book;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{
	
	@Query("SELECT b FROM Book b WHERE b.name= :name")
	Optional<Book> findByName(@Param("name") String name);
}
