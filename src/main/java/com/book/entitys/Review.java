package com.book.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Review {
    
    @Id
    private int reviewId;
    private double rating;
    private String review;
    
}

