package com.sezer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.sezer.mapper", "com.sezer.book"})
public class BookRestAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookRestAppApplication.class, args);
	}

}
