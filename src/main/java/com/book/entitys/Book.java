package com.book.entitys;

import java.util.ArrayList;
import java.util.List;

import com.book.enums.Genre;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Book 
{
	@Id
	@Column(name="BookId")
	private int bookId;
	
	@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]*", message = "Book Name should Start with capital letter")
	@Column(name="Book_Name")
	private String bookName;
	
	private String description;
	
	private Genre genre;
	
	private double price;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Review> reviews=new ArrayList<>();

}
