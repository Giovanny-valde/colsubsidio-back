package com.banco.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void endPoint_get_prices_return_OK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cuentas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void endPoint_return_by_id() throws Exception {
        String id = "1";
        mockMvc.perform(MockMvcRequestBuilders.get("/cuentas/" + id))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.numero").value(456321))
                .andExpect(jsonPath("$.saldo").value(100.00))
                .andExpect(jsonPath("$.cliente.id").value(1))
                .andExpect(jsonPath("$.cliente.nombre").value("Gonzalo Andrade"));
    }

}