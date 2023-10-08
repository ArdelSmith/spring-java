package com.example.demoweb;

import com.example.demoweb.model.Post;
import com.example.demoweb.repository.PostRepository;
import com.example.demoweb.service.LikesService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
@SpringBootTest
class LikeTest {


    @Autowired
    private LikesService likesService;

    @MockBean
    private PostRepository postRepository;

    @Test
    public void like(){
        Long id = 0L;
        var post = new Post(id, "test", new Date());
        Assert.assertTrue(post.getId() != null);
        Mockito.doReturn(Optional.of(post))
                .when(postRepository)
                .findById(id);
        likesService.like(post.getId());
        Mockito.verify(postRepository, Mockito.times(1)).findById(post.getId());
        Mockito.verify(postRepository, Mockito.times(1)).save(post);
    }
}
