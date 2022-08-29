package com.sezer.book;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@ToString
public class BookDTO {
	private int id;
	private String ISBN;
	private String bookName;
	private LocalDate publishDate;
}
