package com.example.demoweb;

import com.example.demoweb.repository.PostRepository;
import com.example.demoweb.service.PostService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class CreateTest {

    @Autowired
    private PostService postService;

    @MockBean
    private PostRepository postRepository;

    @Test
    public void tryCreatePost(){
        String text = "text";
        var post = postService.create(text);
        Assert.assertNotNull(post);
        Assert.assertNotNull(post.getText());
        Assert.assertEquals(post.getText(), text);
        Mockito.verify(postRepository, Mockito.times(1)).save(post);
    }
}
