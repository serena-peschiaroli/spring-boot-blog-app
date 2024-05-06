package com.serpes.springbootblogapp.repository;


import com.serpes.springbootblogapp.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//inherit  CRUD and JPA operations for Post with Long
@Repository
public interface PostRepository extends JpaRepository <Post, Long> {
}
