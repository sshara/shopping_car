package com.spring_course.shopping_car.application.service;

import com.spring_course.shopping_car.application.dto.ItemCarDto;
import com.spring_course.shopping_car.application.dto.ResponseDto;
import com.spring_course.shopping_car.application.dto.ShoppingcarDto;

public interface ShoppingCarService {

    ResponseDto getShoppingCarById(int id);

    ResponseDto createShoppingCar(ShoppingcarDto shoppingCar);

    ResponseDto getAll();

    ResponseDto delete(Integer id);

    ResponseDto update(ItemCarDto itemCar, Integer idShoppingCar);

}
