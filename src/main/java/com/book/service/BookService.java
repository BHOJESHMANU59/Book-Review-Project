package com.book.service;

import java.util.List;

import com.book.dto.BookDto;
import com.book.entitys.Book;
import com.book.util_response.ResponseStructure;

public interface BookService {

	public ResponseStructure<BookDto> saveBook(int id,Book book);

	public ResponseStructure<List<BookDto>> fetchAll();

	public ResponseStructure<BookDto> findbyId(int bookId);

	public ResponseStructure<BookDto> findbyName(String name);

	public ResponseStructure<BookDto> update(int id, Book book);

	public ResponseStructure<String> delete(int id);

}
