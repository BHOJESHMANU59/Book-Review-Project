package com.book.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.book.dto.BookDto;
import com.book.dto.UserDto;
import com.book.entitys.Book;
import com.book.entitys.User;
import com.book.exceptions.BookIdNotFoundException;
import com.book.exceptions.BookNotFoundException;
import com.book.exceptions.UserDetailsNotFoundException;
import com.book.repository.BookRepository;
import com.book.repository.UserRepository;
import com.book.serviceimpl.BookServiceImpl;
@Repository
public class BookDao {
	@Autowired
	private BookRepository repo;
	
	@Autowired
	private UserRepository repo1;
	
	@Autowired
	private BookDto dto;

	public BookDto saveBook(int id,Book book) 
	{
		Book b;
		Optional<User> user = repo1.findById(id);
		if(user.isPresent())
		{
			book.setUser(user.get());
			b = repo.save(book);
		}
		else
		{
			throw new UserDetailsNotFoundException("User Id Not Found");
		}
		
		if(b!=null)
		{
			dto.setBookId(b.getBookId());
			dto.setBookName(b.getBookName());
			dto.setDescription(b.getDescription());
			dto.setGenre(b.getGenre());
			dto.setPrice(b.getPrice());
		
			
			return dto;
		}
		throw new BookNotFoundException("Book Data Not Found");
	}

	public List<BookDto> fetchAll() 
	{
		List<Book> bookAll = repo.findAll();
		
		List<BookDto> b=new ArrayList<>();
		
		if(!bookAll.isEmpty())
		{
			for (Book book : bookAll) 
			{
				dto.setBookId(book.getBookId());
				dto.setBookName(book.getBookName());
				dto.setDescription(book.getDescription());
				dto.setGenre(book.getGenre());
				dto.setPrice(book.getPrice());
			    dto.setUser(book.getUser());
				dto.setReviews(book.getReviews());
				b.add(dto);
				
			}
			return b;
		}
		throw new BookNotFoundException("Book Details Not Found");
		
		
	}

	public BookDto findById(int bookId) 
	{
		Optional<Book> book = repo.findById(bookId);
		
		if(book.isPresent())
		{
			dto.setBookId(book.get().getBookId());
			dto.setBookName(book.get().getBookName());
			dto.setDescription(book.get().getDescription());
			dto.setGenre(book.get().getGenre());
			dto.setPrice(book.get().getPrice());
			dto.setUser(book.get().getUser());
			dto.setReviews(book.get().getReviews());
			
			return dto;
			
		}
		throw new BookIdNotFoundException("Invalid Book Id");
		
	}

	public BookDto findbyName(String name) 
	{
		Book book = repo.findByBookName(name);
		if(book!=null)
		{
			dto.setBookId(book.getBookId());
			dto.setBookName(book.getBookName());
			dto.setDescription(book.getDescription());
			dto.setGenre(book.getGenre());
			dto.setPrice(book.getPrice());
		    dto.setUser(book.getUser());
			dto.setReviews(book.getReviews());
			
			return dto;
		}
		throw new BookNotFoundException("Book Not Found");
		
		
	}

	public BookDto update(int id, Book book) 
	{
		Optional<Book> b = repo.findById(id);
		if(b.isPresent())
		{
			Book bk = b.get();
			bk.setBookId(book.getBookId());
			bk.setBookName(book.getBookName());
			bk.setDescription(book.getDescription());
			bk.setGenre(book.getGenre());
			bk.setPrice(book.getPrice());
			
			Book book1 = repo.save(bk);
			
			dto.setBookId(book1.getBookId());
			dto.setBookName(book1.getBookName());
			dto.setDescription(book1.getDescription());
			dto.setGenre(book1.getGenre());
			dto.setPrice(book1.getPrice());
		  
			return dto;
			
		}
		throw new BookIdNotFoundException("Invalid Book Id");
		
	}

	public String delete(int id) 
	{
		Optional<Book> book = repo.findById(id);
		if(book.isPresent())
		{
			repo.delete(book.get());
			return "Book Data Deleted Successfully "+book.get().getBookId();
		}
		throw new BookIdNotFoundException("Invalid Book id");
	}

}
