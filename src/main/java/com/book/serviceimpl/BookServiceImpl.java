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

	@Override
	public ResponseStructure<BookDto> findbyId(int bookId) 
	{
		BookDto book = dao.findById(bookId);
		
		ResponseStructure<BookDto> response=new ResponseStructure<>();
		response.setData(book);
		response.setHttpStatus(HttpStatus.FOUND);
		response.setMessage("Book Data Retrived Successfully");
		return response;
		
	}

	@Override
	public ResponseStructure<BookDto> findbyName(String name) 
	{
		BookDto book = dao.findbyName(name);
		
		ResponseStructure<BookDto> response =new ResponseStructure<>();
		response.setData(book);
		response.setHttpStatus(HttpStatus.FOUND);
		response.setMessage("Book Data Retrived Successfully");
		return response;
	}

	@Override
	public ResponseStructure<BookDto> update(int id, Book book) 
	{
		BookDto bk = dao.update(id,book);
		
		ResponseStructure<BookDto> response =new ResponseStructure<>();
		response.setData(bk);
		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Book Data Updated Successfully");
		return response;
		
	}

	@Override
	public ResponseStructure<String> delete(int id) 
	{
        String delete = dao.delete(id);
		
		ResponseStructure<String> response =new ResponseStructure<>();
		response.setData(delete);
		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Book Data Deleted Successfully");
		return response;
		
	}
	
	

}
