package com.example.ktm.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public final class Producer {

  private static final Logger logger = LoggerFactory.getLogger(Producer.class);

  @Autowired
  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String message) {
    String topicName = "topic1";
    CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);

    future.whenComplete((stringStringSendResult, throwable) -> {
      if(throwable == null) {
        logger.info("Sent message successfully");
      }
      else {
        logger.error("Failed to send message", throwable);
      }
    });
  }
}