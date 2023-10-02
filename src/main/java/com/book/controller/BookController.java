package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.dto.BookDto;
import com.book.entitys.Book;
import com.book.service.BookService;
import com.book.util_response.ResponseStructure;



@RestController
@RequestMapping("/books")
public class BookController 
{
	@Autowired
	private BookService service;
	
	@PostMapping("/user/{id}/create")
	public ResponseEntity<ResponseStructure<BookDto>> saveBook(@PathVariable int id,@RequestBody Book book)
	{
		ResponseStructure<BookDto> responseStructure=service.saveBook(id,book);
		
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@GetMapping("/getAllBooks")
	public ResponseEntity<ResponseStructure<List<BookDto>>> getAll()
	{
		ResponseStructure<List<BookDto>> responseStructure=service.fetchAll();
		
		return new ResponseEntity<ResponseStructure<List<BookDto>>>(responseStructure,responseStructure.getHttpStatus());
	}
	@GetMapping("{bookId}")
	public ResponseEntity<ResponseStructure<BookDto>> findbyId(@PathVariable int bookId)
	{
		ResponseStructure<BookDto> responseStructure=service.findbyId(bookId);
		
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@GetMapping("book/{bookName}")
	public ResponseEntity<ResponseStructure<BookDto>> findbyName(@PathVariable("bookName") String name)
	{
		ResponseStructure<BookDto> responseStructure=service.findbyName(name);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
		
	}
	
	@PutMapping("{bookId}/book")
	public ResponseEntity<ResponseStructure<BookDto>> update(@PathVariable ("bookId") int id,@RequestBody Book book)
	{
		ResponseStructure<BookDto> responseStructure=service.update(id,book);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@DeleteMapping("book/{bookId}")
	public ResponseEntity<ResponseStructure<String>> delete(@PathVariable ("bookId")  int id)
	{
		ResponseStructure<String> responseStructure=service.delete(id);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	
	

}
