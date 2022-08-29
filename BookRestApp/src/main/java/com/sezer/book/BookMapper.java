package com.sezer.book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

	@Mapping(source = "title", target = "bookName")
	@Mapping(source = "isbn", target = "ISBN")
	BookDTO bookToBookDTO(Book book);
	Book bookDTOToBook(BookDTO dto);
	
}
