package com.example.ktm.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "review")
public class Review {

    @Id
    private String id;

    @Field("Content")
    private String content;
}
