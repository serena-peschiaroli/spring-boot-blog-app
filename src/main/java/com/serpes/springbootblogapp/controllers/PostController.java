package com.serpes.springbootblogapp.controllers;

import com.serpes.springbootblogapp.models.Account;
import com.serpes.springbootblogapp.models.Post;
import com.serpes.springbootblogapp.services.AccountService;
import com.serpes.springbootblogapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class PostController {
    //injects the PostService instance
     @Autowired
    private PostService postService;

     @Autowired
    private AccountService accountService;

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

     @GetMapping("/posts/new")
    public String createNewPost(Model model){
         Optional<Account> optionalAccount = accountService.findByEmail("user.user@domain.com");
                 if(optionalAccount.isPresent()){
                     Post post = new Post();
                     post.setAccount(optionalAccount.get());
                     model.addAttribute("post", post);
                     return "post_new";
                 }else{
                     return "redirect:/";
                 }
     }

     @PostMapping("/posts/new")
    public String saveNewPost(@ModelAttribute Post post){
         postService.save(post);
         return "redirect:/posts/" + post.getId();
     }


     @GetMapping("/posts/{id}/edit")
    @PreAuthorize("isAuthenticated()")
    public String getPostForEdit(@PathVariable Long id, Model model){

         //find post by id
         Optional<Post> optionalPost = postService.getById(id);
         if(optionalPost.isPresent()){
             Post post = optionalPost.get();
             model.addAttribute("post", post);
             return "post_edit";

         }else {
             return "404";
         }
     }

     @PostMapping("/posts/{id}")
    @PreAuthorize("isAuthenticated()")
    public String updatePost(@PathVariable Long id, Post post, BindingResult result, Model model){
         Optional<Post> optionalPost = postService.getById(id);
         if(optionalPost.isPresent()){
             Post existingPost = optionalPost.get();

             existingPost.setTitle(post.getTitle());
             existingPost.setBody(post.getBody());

             postService.save(existingPost);
         }
         return "redirect:/posts/" + post.getId();
     }





    @GetMapping("/posts/{id}/delete")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deletePost(@PathVariable Long id){
         Optional<Post> optionalPost = postService.getById(id);
         if(optionalPost.isPresent()) {
             Post post = optionalPost.get();
             postService.delete(post);
             return "redirect:/";
         }else{
             return "404";
         }
    }

}
