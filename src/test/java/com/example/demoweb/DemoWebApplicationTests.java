package com.example.demoweb;

import com.example.demoweb.controller.LikesController;
import com.example.demoweb.controller.PostCreateController;
import com.example.demoweb.controller.PostsViewController;
import com.example.demoweb.repository.PostRepository;
import com.example.demoweb.service.LikesService;
import com.example.demoweb.service.PostService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ModelAttribute;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoWebApplicationTests {

	@Autowired
	private LikesController likesController;

	@Autowired
	private PostService postService;


	//Этот тест лайкает пост и проверяет, что новое количество лайков равно старому + 1 (точно работает)
	@Test
	public void tryToLike() throws Exception{
		var post = postService.listAllPosts().iterator().next();
		int actual = post.getLikes();
		likesController.like(post.getId());
		System.out.println(actual + " " + post.getLikes());
		post = postService.listAllPosts().iterator().next();
		assertEquals(actual + 1, (int)post.getLikes());
	}
}
