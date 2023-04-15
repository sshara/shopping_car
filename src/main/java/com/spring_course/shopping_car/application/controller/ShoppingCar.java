package com.spring_course.shopping_car.application.controller;

import com.spring_course.shopping_car.application.dto.ItemCarDto;
import com.spring_course.shopping_car.application.dto.ResponseDto;
import com.spring_course.shopping_car.application.dto.ShoppingcarDto;
import com.spring_course.shopping_car.application.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/shoppingcar")
public class ShoppingCar {

    @Autowired
    private ShoppingCarService shoppingCarService;


    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> getShoppingCarById(@PathVariable(required = true) @Min(1) int id){
        return new ResponseEntity<ResponseDto>(shoppingCarService.getShoppingCarById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getAll(){
        return  new ResponseEntity<ResponseDto>(shoppingCarService.getAll(), HttpStatus.OK);
    }

    @PostMapping ()
    public ResponseEntity<ResponseDto> createShoppingCar(@Valid @RequestBody ShoppingcarDto shoppingCar){
        return new ResponseEntity<ResponseDto>(shoppingCarService.createShoppingCar(shoppingCar), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateShoppingCarByItem(@PathVariable(required = true) @Min(1) int id, @Valid @RequestBody ItemCarDto itemCarDto){
        return new ResponseEntity<ResponseDto>(shoppingCarService.update(itemCarDto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteShoppingCar(@PathVariable(required = true) @Min(1) int id){
        return new ResponseEntity<ResponseDto>(shoppingCarService.delete(id), HttpStatus.OK);
    }




}
