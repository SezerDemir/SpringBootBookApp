package com.sezer.book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

	@Mapping(source = "name", target = "bookName")
	BookDTO bookToBookDTO(Book book);
	Book bookDTOToBook(BookDTO dto);
	
}
