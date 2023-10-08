package com.example.demoweb;

import com.example.demoweb.repository.PostRepository;
import com.example.demoweb.service.LikesService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
@SpringBootTest
class LikeTest {


    @MockBean
    private LikesService likesService;

    @MockBean
    private PostRepository postRepository;

    @Test
    public void someFunction(){
    }
}
