package com.spring_course.shopping_car.application.controller;

import com.spring_course.shopping_car.application.dto.ItemCarDto;
import com.spring_course.shopping_car.application.dto.ResponseDto;
import com.spring_course.shopping_car.application.dto.ShoppingcarDto;
import com.spring_course.shopping_car.application.service.ShoppingCarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shoppingcar")
public class ShoppingCar {

    @Autowired
    private ShoppingCarService shoppingCarService;


    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getShoppingCarById(@PathVariable(required = true) @Min(1) int id){

        return new ResponseEntity<>(shoppingCarService.getShoppingCarById(id), HttpStatus.OK);

    }

    @PostMapping ()
    public ResponseEntity<ResponseDto> createShoppingCar(@Valid @RequestBody ShoppingcarDto shoppingCar){
        return new ResponseEntity<>(shoppingCarService.createShoppingCar(shoppingCar), HttpStatus.OK);
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
