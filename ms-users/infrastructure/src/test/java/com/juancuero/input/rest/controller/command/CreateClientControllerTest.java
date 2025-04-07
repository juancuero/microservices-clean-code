package com.juancuero.input.rest.controller.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juancuero.TestApplication;
import com.juancuero.input.rest.controller.command.request.CreateClientRequest;
import com.juancuero.model.enums.ClientStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Testcontainers
@SpringBootTest(classes = TestApplication.class)
@AutoConfigureMockMvc
public class CreateClientControllerTest {

    //PENDING TO REFACTOR
    @Container
    public static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("testdb")
            .withUsername("postgres")
            .withPassword("postgres");

    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresContainer::getUsername);
        registry.add("spring.datasource.password", postgresContainer::getPassword);
    }

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Test
    void shouldCreateClientSuccessfully() throws Exception {
        CreateClientRequest request = new CreateClientRequest(
                "Juan Cuero",
                "M",
                29,
                "1121924150",
                "Calle falsa 123",
                "3000000000",
                "password123"
        );

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.uuid", notNullValue()))
                .andExpect(jsonPath("$.name", is("Juan Cuero")))
                .andExpect(jsonPath("$.identification", is("1121924150")))
                .andExpect(jsonPath("$.phone", is("3000000000")))
                .andExpect(jsonPath("$.status", is(ClientStatus.ACTIVE.toString())))
                .andExpect(jsonPath("$.created_at", notNullValue()))
                .andExpect(jsonPath("$.last_modified_at", notNullValue()));
    }

    @Test
    void shouldReturnConflictWhenClientAlreadyExists() throws Exception {
        CreateClientRequest request = new CreateClientRequest(
                "Luisa Romero",
                "F",
                26,
                "123456789",
                "Calls falsa 123",
                "300220220",
                "password123"
        );

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isConflict());
    }
}
