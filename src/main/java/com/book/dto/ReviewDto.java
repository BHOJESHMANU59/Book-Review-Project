package com.book.dto;

import org.springframework.stereotype.Component;


import lombok.Data;

@Component
@Data
public class ReviewDto
{
	private int reviewId;
	private double rating;
	private String review;

}
