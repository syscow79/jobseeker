package com.syscow.jobseeker;

import com.syscow.jobseeker.entity.Position;
import com.syscow.jobseeker.repository.PositionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class JobseekerControllerIntegrationTest {

    @MockBean
    private PositionRepository positionRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenPostRequestToValidPositionWithApiKey() throws Exception {
        when(positionRepository.save(any(Position.class)))
                .thenReturn(Position.builder().id(9999).build());
        this.mockMvc
                .perform(post("/job/position")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("API_KEY", "02807308-92a9-4150-a582-f47ef2b42861")
                        .content("{\"name\":\"agent\", \"address\": \"Berkshire\"}")
                )
                .andExpect(content().string("http://localhost/job/position/9999"))
                .andExpect(status().isOk());
    }

    @Test
    public void whenPostRequestToInvalidPositionWithApiKey() throws Exception {
        this.mockMvc
                .perform(post("/job/position")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("API_KEY", "02807308-92a9-4150-a582-f47ef2b42861")
                        .content("{\"name\":\"agen\", \"address\": \"Berk\"}")
                )
                .andExpect(jsonPath("$.name").value("size must be between 5 and 50"))
                .andExpect(jsonPath("$.address").value("size must be between 5 and 50"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenPostRequestToAlreadyExistsWithApiKey() throws Exception {
        this.mockMvc
                .perform(post("/job/position")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("API_KEY", "02807308-92a9-4150-a582-f47ef2b42861")
                        .content("{\"name\":\"agen\", \"address\": \"Berk\"}")
                )
                .andExpect(jsonPath("$.name").value("size must be between 5 and 50"))
                .andExpect(jsonPath("$.address").value("size must be between 5 and 50"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void whenPostRequestWithoutApiKey() throws Exception {
        this.mockMvc
                .perform(post("/job/position"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }


}
