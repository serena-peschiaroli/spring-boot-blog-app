package com.serpes.springbootblogapp.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity  //  this class is a JPA entity.
@Getter  // lombok annotation to generate getters for all fields.
@Setter  // lombok annotation to generate setters for all fields.
public class Post {
    // id as primary key
    @Id
    //specifies that id shoyuld be automatically generated using database sequence
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    private String title;

    //specifies that body coluymn should be stored as text type
    @Column(columnDefinition= "TEXT")
    private String body;

    private LocalDateTime createdAt;
}
