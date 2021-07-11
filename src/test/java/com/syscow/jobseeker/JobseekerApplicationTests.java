package com.syscow.jobseeker;

import com.syscow.jobseeker.entity.Position;
import com.syscow.jobseeker.entity.User;
import com.syscow.jobseeker.repository.PositionRepository;
import com.syscow.jobseeker.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class JobseekerApplicationTests {

	@MockBean
	private UserRepository userRepository;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void whenPostRequestToExistingUser() throws Exception {
		when(userRepository.findName("Sanyi"))
				.thenReturn(Collections.singletonList(User.builder().id(9999).build()));
		this.mockMvc
				.perform(post("/admin/user")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"name\":\"Sanyi\", \"email\":\"email@example.com\"}")
				)
				.andExpect(content().string("User already exists"))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void whenPostRequestToValidUser() throws Exception {
		when(userRepository.findName("Sanyi"))
				.thenReturn(Collections.emptyList());
		String apiKey = UUID.randomUUID().toString();
		when(userRepository.save(any(User.class)))
				.thenReturn(User.builder().apiKey(apiKey).build());
		this.mockMvc
				.perform(post("/admin/user")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"name\":\"Sanyi\", \"email\":\"email@example.com\"}")
				)
				.andExpect(content().string(apiKey))
				.andExpect(status().isOk());
	}

}
