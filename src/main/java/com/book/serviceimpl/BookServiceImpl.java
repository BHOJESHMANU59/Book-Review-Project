package com.book.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.book.dao.BookDao;
import com.book.dto.BookDto;
import com.book.entitys.Book;
import com.book.service.BookService;
import com.book.util_response.ResponseStructure;
@Service
public class BookServiceImpl implements BookService 
{
	@Autowired
	private BookDao dao;

	@Override
	public ResponseStructure<BookDto> saveBook(int id,Book book) {
		
		BookDto b = dao.saveBook(id,book);
		ResponseStructure<BookDto> response =new ResponseStructure<>();
		response.setData(b);
		response.setHttpStatus(HttpStatus.CREATED);
		response.setMessage("Book Data Inserted Successfully!!!");
		return response;
	}

	@Override
	public ResponseStructure<List<BookDto>> fetchAll() 
	{
		List<BookDto> fetchAll = dao.fetchAll();
		ResponseStructure<List<BookDto>> response=new ResponseStructure<>();
		response.setData(fetchAll);
		response.setHttpStatus(HttpStatus.FOUND);
		response.setMessage("Book Data Retrived Successfully");
		return response;
	}

}
