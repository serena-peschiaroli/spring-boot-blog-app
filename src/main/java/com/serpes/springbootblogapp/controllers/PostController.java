package com.serpes.springbootblogapp.controllers;

import com.serpes.springbootblogapp.models.Post;
import com.serpes.springbootblogapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class PostController {
    //injects the PostService instance
     @Autowired
    private PostService postService;

     @GetMapping("/posts/{id}")
    public String getPost(@PathVariable Long id, Model model){
         //find the post by id and result is wrapped in an Optional
         Optional<Post> optionalPost = postService.getById(id);
         //if the post exists, retrieve it from the Optional wrapper.
         if(optionalPost.isPresent()){
             Post post = optionalPost.get();
             // add the retrieved post to the model and makes post object available
             model.addAttribute("post", post);
             return "post";

         }else{
             return "404";
         }

     }
}
