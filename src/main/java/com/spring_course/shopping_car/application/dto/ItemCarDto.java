package com.spring_course.shopping_car.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCarDto {

    @NotBlank(message = "valor requerido")
    @NotEmpty(message = "longitud de la cadena mayor a 0")
    @NotNull(message = "valor requerido")
    private String name;

    @NotNull
    @Min(1)
    private int amount;

    @NotNull
    private Double price;

    @NotBlank
    @NotEmpty
    @NotNull
    private String description;
}
