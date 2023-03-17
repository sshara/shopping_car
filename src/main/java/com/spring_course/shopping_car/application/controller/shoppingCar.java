package com.spring_course.shopping_car.application.controller;

import com.spring_course.shopping_car.application.dto.ItemCarDto;
import com.spring_course.shopping_car.application.dto.ResponseDto;
import com.spring_course.shopping_car.application.dto.ShoppingcarDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shoppingcar")
public class shoppingCar {

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getShoppingCarById(@PathVariable(required = true) @Min(1) int id){
        ResponseEntity<ResponseDto> response;
        ResponseDto responseDto = new ResponseDto<>();

        try {

            responseDto.setCode("00");
            responseDto.setMessage("Ok");
            //--codigo para dar una respuesta se removera mas adelante cuando se contruya el resto de funcionalidad
            ItemCarDto itemcarDto = new ItemCarDto("gatito", 1, 1.59, "gato pelicorto americano atrigrado amarillo con blanco");
            List<ItemCarDto> list = new ArrayList<>();
            list.add(itemcarDto);
            ShoppingcarDto shoppingcarDto = new ShoppingcarDto("1", list);
            responseDto.setData(shoppingcarDto);

            //--
            response = new ResponseEntity(responseDto, HttpStatus.OK);
        }catch (Exception e){
            responseDto.setCode("01");
            responseDto.setMessage("Ningun item coincide con el parametro ingresado");
            response = new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @PostMapping ()
    public ResponseEntity<ResponseDto> createShoppingCar(@Valid @RequestBody ShoppingcarDto shoppingCar){
        ResponseEntity<ResponseDto> response;
        ResponseDto responseDto = new ResponseDto<>();
        try {
            responseDto.setCode("00");
            responseDto.setMessage("Objeto creado correctamente");
            response = new ResponseEntity(responseDto, HttpStatus.OK);
        }catch (Exception e){
            responseDto.setCode("02");
            responseDto.setMessage("Error al crear el objeto, contacte con soporte");
            response = new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    @PutMapping()
    public ResponseEntity<ResponseDto> updateShoppingCarByItem(@Valid @RequestBody ItemCarDto itemCar){
        ResponseEntity<ResponseDto> response;
        ResponseDto responseDto = new ResponseDto<>();
        try {
            responseDto.setCode("00");
            responseDto.setMessage("Objecto actualizado correctamente");
            response = new ResponseEntity(responseDto, HttpStatus.OK);
        }catch (Exception e){
            responseDto.setCode("02");
            responseDto.setMessage("Error al actualizar el objeto, contacte con soporte");
            response = new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteShoppingCar(@PathVariable(required = true) @Min(1) int id){

        ResponseEntity<ResponseDto> response;
        ResponseDto responseDto = new ResponseDto<>();
        try {
            responseDto.setCode("00");
            responseDto.setMessage("Objecto eliminado correctamente");
            response = new ResponseEntity(responseDto, HttpStatus.OK);
        }catch (Exception e){
            responseDto.setCode("02");
            responseDto.setMessage("No fue posible eliminar el objecto, contacte con soporte");
            response = new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }


}
