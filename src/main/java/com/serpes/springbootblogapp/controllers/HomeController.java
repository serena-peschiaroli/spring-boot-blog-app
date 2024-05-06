package com.serpes.springbootblogapp.controllers;

import com.serpes.springbootblogapp.models.Post;
import com.serpes.springbootblogapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 *  main entry point for the web application,
 * handling requests to the root
 */
@Controller
public class HomeController {

    // Automatically injects an instance of PostService to handle data operations related to posts
    @Autowired
    private PostService postService;

    //hndles GET requests to the root and retrieves all blog posts

    @GetMapping("/")
    public String home(Model model){
        // retrieve a list of all posts using the postService
        List<Post> posts = postService.getAll();
        // adds the retrieved posts to the model under the attribute name 'posts'
        model.addAttribute("posts", posts);
        // returns the name of the Thymeleaf template (home.html) that should be rendered, with model attributes.
        return "home";
    }
}
