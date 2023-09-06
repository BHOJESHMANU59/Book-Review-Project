package com.book.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.book.dao.ReviewDao;
import com.book.dto.ReviewDto;
import com.book.entitys.Review;
import com.book.service.ReviewService;
import com.book.util_response.ResponseStructure;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewDao dao;

	@Override
	public ResponseStructure<ReviewDto> saveReviws(int id,int uid,Review review)
	{
		ReviewDto reviewDto = dao.saveReviews(id,uid,review);
		
		ResponseStructure<ReviewDto> response=new ResponseStructure<>();
		response.setData(reviewDto);
		response.setHttpStatus(HttpStatus.CREATED);
		response.setMessage("Reviews Are Saved  Successfully");
		return response;
	}

	@Override
	public ResponseStructure<List<ReviewDto>> fetchAll() 
	{
	  List<ReviewDto> all = dao.fetchAll();
	  ResponseStructure<List<ReviewDto>> response=new ResponseStructure<>();
	  response.setData(all);
	  response.setHttpStatus(HttpStatus.FOUND);
	  response.setMessage("Data Retrived Sussfully");
	  
	  return response;
	}

}
