package com.book.dto;


import java.util.List;

import org.springframework.stereotype.Component;

import com.book.entitys.Review;
import com.book.entitys.User;
import com.book.enums.Genre;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Component
public class BookDto {
	
   private int bookId;
	
	@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]*", message = "Book Name should Start with capital letter")
	@Column(name="Book_Name")
	private String bookName;
	
	private String description;
	private Genre genre;
	private double price;
	
	private User user;
	
	private List<Review> reviews;
	
	

}
