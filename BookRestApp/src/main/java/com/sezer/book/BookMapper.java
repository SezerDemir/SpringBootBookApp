package com.sezer.book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookMapper {
	
	@Mapping(source = "name", target="bookName")
	BookDTO toDTO(Book book);
	
	@Mapping(source = "bookName", target = "name")
	Book toBook(BookDTO dto);
	
}
