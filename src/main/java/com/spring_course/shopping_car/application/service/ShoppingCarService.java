package com.spring_course.shopping_car.application.service;

import com.spring_course.shopping_car.application.dto.ResponseDto;
import com.spring_course.shopping_car.application.dto.ShoppingcarDto;
import com.spring_course.shopping_car.application.entities.Recibo;

import java.util.List;

public interface ShoppingCarService {

    ResponseDto getShoppingCarById(int id);

    ResponseDto createShoppingCar(ShoppingcarDto shoppingCar);

    List<Recibo> getAll();

    List<Recibo> getByDescripcion(String descripcion);

    boolean delete(Integer id);

    Recibo update(Recibo recibo);

}
