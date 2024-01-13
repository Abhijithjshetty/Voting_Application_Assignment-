package com.springboootex.Demo12.controller;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class VotingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void enterCandidate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/entercandidate?name=ajay"))
                .andExpect(status().isOk());
    }

    @Test
    void castVote() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/castvote?name=ajay"))
                .andExpect(status().isOk());
    }

    @Test
    void countVote() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/countvote?name=ajay"))
                .andExpect(status().isOk());
    }

    @Test
    void listVotes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/listvote"))
                .andExpect(status().isOk());
    }

    @Test
    void getWinner() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getwinner"))
                .andExpect(status().isOk());
    }
}
