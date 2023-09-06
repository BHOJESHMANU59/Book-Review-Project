package com.book.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.book.dto.BookDto;
import com.book.entitys.Book;
import com.book.entitys.User;
import com.book.exceptions.BookNotFoundException;
import com.book.exceptions.UserDetailsNotFoundException;
import com.book.repository.BookRepository;
import com.book.repository.UserRepository;
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
			//	dto.setUser(book.getUser());
				dto.setReviews(book.getReviews());
				b.add(dto);
				
			}
			return b;
		}
		throw new BookNotFoundException("Book Details Not Found");
		
		
	}

}
