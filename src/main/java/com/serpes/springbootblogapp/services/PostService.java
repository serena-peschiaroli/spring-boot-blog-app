package com.serpes.springbootblogapp.services;

import com.serpes.springbootblogapp.models.Post;
import com.serpes.springbootblogapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


//postService manages all operations related to the post entities and crud operations
@Service
public class PostService {

    // injects the PostRepository to interact with the database
    @Autowired
    private PostRepository postRepository;

    //retrieve all posts by id
    public Optional<Post> getById (Long id){
        return postRepository.findById(id);
    }

    //retieves all posts available
    public List<Post> getAll(){
        return postRepository.findAll();
    }

    //if post is null set a timestamp
    public Post save(Post post){
        if (post.getId()== null){
            post.setCreatedAt(LocalDateTime.now());
        }
        //save the post
        return postRepository.save(post);
    }
}
