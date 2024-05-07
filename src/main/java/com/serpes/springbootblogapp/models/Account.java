package com.serpes.springbootblogapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

//TODO: add validation rules

// @NoArgsConstructor is required by JPA for internal operations
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String email;

    private String password;

    private String firstName;
    private String lastName;

    //a user has many post
    @OneToMany(mappedBy = "account")
    private List<Post> posts;

}
