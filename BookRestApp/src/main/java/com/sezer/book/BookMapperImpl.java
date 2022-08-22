package com.sezer.book;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper{

	@Override
	public BookDTO toDTO(Book book) {
		if(book == null)
			return null;
		else {
			 return BookDTO.builder().id(book.getId()).bookName(book.getName()).build();
		}
			
	}

	@Override
	public Book toBook(BookDTO dto) {
		if(dto == null) {
			return null;
		}
		else {
			return Book.builder().name(dto.getBookName()).build();
		}
	}

}
