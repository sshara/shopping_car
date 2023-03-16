package com.spring_course.shopping_car.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
public class ShoppingcarDto {

    @NotBlank
    @NotEmpty
    @NotNull
    private String id;

    @Valid
    private List<ItemCarDto> items;

}
