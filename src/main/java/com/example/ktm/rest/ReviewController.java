package com.example.ktm.rest;

import com.example.ktm.model.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/ktm")
public interface ReviewController {

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> viewAllReviews();

    @PostMapping("/review")
    public void addReview(@RequestBody String review);

}
