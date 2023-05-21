package com.example.demoweb;

import com.example.demoweb.controller.LikesController;
import com.example.demoweb.controller.PostCreateController;
import com.example.demoweb.controller.PostsViewController;
import com.example.demoweb.service.LikesService;
import com.example.demoweb.service.PostService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ModelAttribute;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DemoWebApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private PostService postService;

	@Autowired LikesService likesService;

	@Autowired
	private PostCreateController postCreateController;

	@Autowired
	private PostsViewController postsViewController;
	@Test
	void contextLoads() {
	}

	// Интеграционный тест 1 - если база используется или с ней что-то не так - ломается. Можно включить DBeaver для демонстрации
	@Test
	void tryViewPosts() throws Exception{
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk());
	}

	// Интеграционный тест 2 - пытаемся создать пост с надписью bebra, и он создаётся
	@Test
	void tryCreate() throws Exception{
		this.mockMvc.perform(post("/new").param("text", "bebra"))
				.andDo(print())
				.andExpect(status().isFound());
	}
}
