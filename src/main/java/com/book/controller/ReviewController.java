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

import com.book.dto.ReviewDto;
import com.book.entitys.Review;
import com.book.service.ReviewService;
import com.book.util_response.ResponseStructure;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService service;
	
	@PostMapping("/book/{id}/user/{uid}/create")
	public ResponseEntity<ResponseStructure<ReviewDto>> saveReview(@PathVariable int id,@PathVariable int uid, @RequestBody Review review)
	{
		ResponseStructure<ReviewDto> responseStructure=service.saveReviws(id,uid,review);
		return new ResponseEntity<ResponseStructure<ReviewDto>>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@GetMapping("/getAllReviews")
	public ResponseEntity<ResponseStructure<List<ReviewDto>>> fetchAll()
	{
		ResponseStructure<List<ReviewDto>> responseStructure=service.fetchAll();
		return new ResponseEntity<ResponseStructure<List<ReviewDto>>>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@GetMapping("{reviweId}")
	public ResponseEntity<?> findbyId(@PathVariable ("reviweId")int id)
	{
		ResponseStructure<?> responseStructure=service.findbyId(id);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@PutMapping("{reviewId}/review")
	public ResponseEntity<?> update(@PathVariable ("reviewId") int id,@RequestBody Review review)
	{
		ResponseStructure<?> responseStructure=service.update(id,review);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@DeleteMapping("delete/{reviewId}")
	public ResponseEntity<?> delete(@PathVariable int reviewId)
	{
		ResponseStructure<?> responseStructure=service.delete(reviewId);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
		
	}

}
