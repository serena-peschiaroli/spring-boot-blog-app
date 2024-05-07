package com.serpes.springbootblogapp.config;

import com.serpes.springbootblogapp.models.Account;
import com.serpes.springbootblogapp.models.Post;
import com.serpes.springbootblogapp.services.AccountService;
import com.serpes.springbootblogapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//implements CommandLineRunner to populate the database with initial data when appp starts
@Component
public class SeedData implements CommandLineRunner {

    //injects Postservice to perform CRUD
    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;



    // retrieves all existing posts from the database.
    @Override
    public void run(String... args) throws Exception{

        List<Post> posts = postService.getAll();
        //if the repository is empty seeds data

        if(posts.size() == 0) {

            //adding account to seeder

            Account account1 = new Account();

            Account account2 = new Account();

            account1.setFirstName("user");
            account1.setLastName("user");
            account1.setEmail("user.user@domain.com");
            account1.setPassword("password");

            account2.setFirstName("admin");
            account2.setLastName("admin");
            account2.setEmail("admin.admin@domain.com");
            account2.setPassword("password");

            accountService.save(account1);
            accountService.save(account2);

            //create and setting new post
            Post post1 = new Post();
            post1.setTitle(("Title of post 1"));
            post1.setBody("This is the body of post 1");
            post1.setAccount(account1);

            Post post2 = new Post();
            post2.setTitle("Title of post 2");
            post2.setBody("This is the body of post 2");
            post1.setAccount(account2);

            //saving post
            postService.save(post1);
            postService.save(post2);

        }
    }
}
