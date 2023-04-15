package com.spring_course.shopping_car.application.service;

import com.spring_course.shopping_car.application.dto.ItemCarDto;
import com.spring_course.shopping_car.application.dto.ResponseDto;
import com.spring_course.shopping_car.application.dto.ShoppingcarDto;
import com.spring_course.shopping_car.infrastructure.persistence.entities.ShoppingCar;

import javax.validation.Valid;
import java.util.List;

public interface ShoppingCarService {

    ResponseDto getShoppingCarById(int id);

    ResponseDto createShoppingCar(ShoppingcarDto shoppingCar);

    ResponseDto getAll();

    ResponseDto delete(Integer id);

    ResponseDto update(ItemCarDto itemCar, Integer idShoppingCar);

}
