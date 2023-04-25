package com.spring_course.shopping_car.application.controller;

import com.spring_course.shopping_car.application.dto.ResponseDto;
import com.spring_course.shopping_car.application.service.ShoppingCarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ShoppingCar.class})
@WebMvcTest(ShoppingCar.class)
class ShoppingCarTest {

    @MockBean
    private ShoppingCarService shoppingCarService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getShoppingCarByIdTestWhenIsOK() throws Exception {

        // Given
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCode("OK");
        responseDto.setMessage("Successful");

        // When
        when(shoppingCarService.getShoppingCarById(anyInt())).thenReturn(responseDto);

        // Then
        mockMvc.perform(get("/shoppingcar/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Successful"));

    }

    @Test
    void getAll() {
    }

    @Test
    void createShoppingCar() {
    }

    @Test
    void updateShoppingCarByItem() {
    }

    @Test
    void deleteShoppingCar() {
    }
}