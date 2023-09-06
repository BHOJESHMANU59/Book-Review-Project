package com.book.service;

import java.util.List;

import com.book.dto.BookDto;
import com.book.entitys.Book;
import com.book.util_response.ResponseStructure;

public interface BookService {

	public ResponseStructure<BookDto> saveBook(int id,Book book);

	public ResponseStructure<List<BookDto>> fetchAll();

}
