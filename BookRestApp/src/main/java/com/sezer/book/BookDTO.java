package com.sezer.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@ToString(includeFieldNames = true)
public class BookDTO {
	private int id;
	private String bookName;
}
