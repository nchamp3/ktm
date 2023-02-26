package com.example.ktm.rest;

import com.example.ktm.database.ReviewRepository;
import com.example.ktm.kafka.producer.Producer;
import com.example.ktm.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewControllerImpl implements ReviewController{

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    Producer producer;

    @Override
    public ResponseEntity<List<Review>> viewAllReviews() {
        return ResponseEntity.ok(reviewRepository.findAll());
    }

    @Override
    public void addReview(String review) {
        producer.sendMessage(review);
    }
}
