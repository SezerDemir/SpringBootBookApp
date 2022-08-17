package com.sezer.book;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

	@Bean
	CommandLineRunner commandLineRunner(BookRepo repo)
	{
		return args -> {
			repo.saveAll(List.of(new Book("Lord of the Rings", LocalDate.of(2021, 12, 15)), new Book("The Hobbit", LocalDate.of(2012, 01, 25))));
		};
	}
}
