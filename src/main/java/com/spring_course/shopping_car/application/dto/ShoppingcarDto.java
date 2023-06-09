package com.spring_course.shopping_car.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingcarDto {


    private String id;

    @Valid
    private List<ItemCarDto> items;

}
