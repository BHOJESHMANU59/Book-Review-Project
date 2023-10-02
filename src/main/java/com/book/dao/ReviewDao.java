package com.book.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.book.dto.ReviewDto;
import com.book.entitys.Book;
import com.book.entitys.Review;
import com.book.entitys.User;
import com.book.exceptions.BookNotFoundException;
import com.book.exceptions.ReviewIdNoFoundException;
import com.book.exceptions.ReviewNotFoundException;
import com.book.repository.BookRepository;
import com.book.repository.ReviewRepository;
import com.book.repository.UserRepository;

@Repository
public class ReviewDao {

	@Autowired
	private ReviewRepository repo;
	
	@Autowired
	private BookRepository repob;
	
	@Autowired
	private UserRepository repou;
	
	@Autowired
	private ReviewDto dto;
	
	
	public ReviewDto saveReviews(int id,int uid,Review review) 
	{
		Review r;
		Optional<Book> book = repob.findById(id);
		Optional<User> user = repou.findById(uid);
		if(book.isPresent())
		{
			user.get().getReviews().add(review);
		    book.get().getReviews().add(review);
		     r=repo.save(review);
		}
		else
		{
			throw new BookNotFoundException("Book Data Not Found");
		}
		
		
		if(r!=null)
		{
			dto.setReviewId(r.getReviewId());
			dto.setRating(r.getRating());
			dto.setReview(r.getReview());
			
			return dto;
		}
		throw new ReviewNotFoundException("Review Details Not Found ");
		
	}


	public List<ReviewDto> fetchAll() 
	{
		
		
		List<Review> review = repo.findAll();
		
		List<ReviewDto> rd=new ArrayList<>();
		
		if(!review.isEmpty())
		{
			for (Review rv : review) 
			{
				ReviewDto rvdto=new ReviewDto();
				
				rvdto.setReviewId(rv.getReviewId());
				rvdto.setRating(rv.getRating());
				rvdto.setReview(rv.getReview());
				rd.add(rvdto);
				
			}
			return rd;
		}
		else
		{
			throw new ReviewNotFoundException("Reviews Not Found");
		}
		
	}


	public ReviewDto findbyId(int id) 
	{
		Optional<Review> review = repo.findById(id);
		if(review.isPresent())
		{
			Review rv = review.get();
			dto.setReviewId(rv.getReviewId());
			dto.setRating(rv.getRating());
			dto.setReview(rv.getReview());
			return dto;
		}
		throw new ReviewIdNoFoundException("Invalid Review Id");
	}


	public ReviewDto update(int id, Review review) 
	{
		Optional<Review> rv = repo.findById(id);
		if(rv.isPresent())
		{
			Review rview = rv.get();
			rview.setReviewId(review.getReviewId());
			rview.setRating(review.getRating());
			rview.setReview(review.getReview());
			
			Review rvw = repo.save(rview);
			
			dto.setReviewId(rvw.getReviewId());
			dto.setRating(rvw.getRating());
			dto.setReview(rvw.getReview());
			return dto;
		}
		throw new ReviewNotFoundException("Reviews Not Found");
	}


	public String delete(int reviewId) 
	{
		Optional<Review> review = repo.findById(reviewId);
		if(review.isPresent())
		{
			repo.delete(review.get());
			return "Review Deleted Successfully "+ review.get().getReviewId();
		}
		throw new ReviewIdNoFoundException("Invalid Review Id");
		
	}



}
