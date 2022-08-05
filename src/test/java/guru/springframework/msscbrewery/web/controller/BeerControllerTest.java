package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@AutoConfigureMockMvc
@SpringBootTest
public class BeerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BeerService beerService;

    @BeforeEach
    void setup() {
        mockMvc = standaloneSetup(new BeerController(beerService))
            .defaultRequest(get("/").accept(MediaType.APPLICATION_JSON))
            .alwaysExpect(status().isOk())
            .alwaysExpect(content().contentType("application/json"))
            .build();
    }

    @Test
    void test() throws Exception{
        UUID uuid = UUID.randomUUID();

        mockMvc.perform(get("/api/v1/beer/{uuid}", uuid))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        content()
                                .json("{\"beerName\": \"Test Beer\", \"beerType\": \"Pale Ale\"}")
                );
    }

}
