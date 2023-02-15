package com.example.demoweb.service;

import com.example.demoweb.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demoweb.controller.PostsViewController.postsService;

@Service
public class LikesService {
@Autowired
PostService postService;
    public Integer like(Long postId){
        Post post = postsService.listAllPosts().get(postId.intValue());
        post.setLikes(post.getLikes() + 1);
        return post.getLikes();
    }
}
