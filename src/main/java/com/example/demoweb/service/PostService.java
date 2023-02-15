package com.example.demoweb.service;

import com.example.demoweb.model.Post;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {
    ArrayList<Post> posts = new ArrayList<>();
    public PostService(){
        create("first");
        create("second");
        create("third");
    }
    public ArrayList<Post> listAllPosts(){
        return posts;
    }
    public void create(String text) {
        posts.add(new Post((long) posts.size(), text, new Date(), 0));
    }
}
