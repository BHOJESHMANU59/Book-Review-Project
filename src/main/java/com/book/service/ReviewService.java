package com.book.service;

import java.util.List;

import com.book.dto.ReviewDto;
import com.book.entitys.Review;
import com.book.util_response.ResponseStructure;

public interface ReviewService {

 public	ResponseStructure<ReviewDto> saveReviws(int id,int uid,Review review);

public ResponseStructure<List<ReviewDto>> fetchAll();

public ResponseStructure<?> findbyId(int id);

public ResponseStructure<?> update(int id, Review review);

public ResponseStructure<?> delete(int reviewId);

}
