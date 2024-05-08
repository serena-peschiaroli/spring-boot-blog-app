package com.serpes.springbootblogapp.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "Title cannot be empty")
    private String title;

    //specifies that body coluymn should be stored as text type
    @Column(columnDefinition= "TEXT")
    @NotBlank(message = "Title cannot be empty")
    private String body;

    private LocalDateTime createdAt;

    //TODO: define  fetch strategies lazy || eager

    //reverse relationship with account, many to one
    //ensures that every post must be associated with an account
    @NotNull
    @ManyToOne
    //specifies the foreign key column that will link posts to accounts
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account account;
}
