package com.spring_course.shopping_car.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    private Integer id;

    @NotBlank(message = "valor requerido")
    @NotEmpty(message = "longitud de la cadena mayor a 0")
    @NotNull(message = "valor requerido")
    @Schema(description = "nombre del objeto agregado", example = "gatito", type = "string")
    private String name;

    @NotNull
    @Min(1)
    private Integer amount;

    @NotNull
    private String price;

    @NotBlank
    @NotEmpty
    @NotNull
    private String description;

}
