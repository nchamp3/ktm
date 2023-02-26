package com.example.ktm.kafka.consumer;

import com.example.ktm.database.ReviewRepository;
import com.example.ktm.model.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Consumer {

    private final ReviewRepository reviewRepository;

    @KafkaListener(topics = "topic1", containerFactory = "kafkaListenerContainerFactory")
    public void consume(String message) {
        Review review = new Review();
        review.setContent(message);

        reviewRepository.insert(review);
    }
}
