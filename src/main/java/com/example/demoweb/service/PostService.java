package com.example.demoweb.service;

import com.example.demoweb.model.Post;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class PostService {
    public static ArrayList<Post> listAllPosts(){
        ArrayList<Post> list = new ArrayList<>();
        Post f = new Post("first one");
        Post s = new Post("second one");
        Post t = new Post("third one");
        list.add(f);
        list.add(s);
        list.add(t);
        return list;
    }
}
