package com.spring_course.shopping_car.application.service;

import com.spring_course.shopping_car.application.dto.ItemCarDto;
import com.spring_course.shopping_car.application.dto.ResponseDto;
import com.spring_course.shopping_car.application.dto.ShoppingcarDto;
import com.spring_course.shopping_car.infrastructure.persistence.entities.ItemEntity;
import com.spring_course.shopping_car.infrastructure.persistence.entities.ShoppingCarEntity;
import com.spring_course.shopping_car.infrastructure.persistence.mapper.ShoppingCarMapper;
import com.spring_course.shopping_car.infrastructure.persistence.repository.ItemRepositoryJpa;
import com.spring_course.shopping_car.infrastructure.persistence.repository.ShoppingCarRepositoryJpa;
import com.spring_course.shopping_car.application.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCarImpl implements ShoppingCarService {

    @Autowired
    private ShoppingCarRepositoryJpa shoppingCarRepositoryJpa;

    @Autowired
    private ShoppingCarMapper shoppingCarMapper;

    @Override
    public ResponseDto getShoppingCarById(int id) {

        ResponseDto responseDto = new ResponseDto<ShoppingcarDto>();

        try {
            responseDto.setData(shoppingCarMapper.toShoppingCarDto((shoppingCarRepositoryJpa.findById(id)).get()));
            responseDto.setCode("00");
            responseDto.setMessage("Ok");

        }catch (Exception e){
            responseDto.setCode("01");
            responseDto.setMessage("Ningun item coincide con el parametro ingresado");
        }

        return responseDto;
    }

    @Override
    public ResponseDto createShoppingCar(ShoppingcarDto shoppingCar) {
        ResponseDto responseDto = new ResponseDto<>();
        try {
            shoppingCarRepositoryJpa.save(shoppingCarMapper.fromShoppingCarDto(shoppingCar));
            responseDto.setCode("00");
            responseDto.setMessage("Objecto creado correctamente");

        }catch (Exception e){
            responseDto.setCode("02");
            responseDto.setMessage("Error al crear el objeto, contacte con soporte");
            e.printStackTrace();
        }

        return responseDto;
    }

    public ResponseDto getAll(){
        ResponseDto responseDto = new ResponseDto<List<ShoppingcarDto>>();
        try{

            responseDto.setData(shoppingCarMapper.toShoppingCarDto(shoppingCarRepositoryJpa.findAll()));
            responseDto.setCode("00");
            responseDto.setMessage("Lista de todos los carritos de compras");

        }catch (Exception e){
            responseDto.setCode("02");
            responseDto.setMessage("Error al traer lista de todos los carritos de compras");
        }

        return responseDto;
    }


    public ResponseDto delete(Integer id){
        ResponseDto responseDto = new ResponseDto<>();
        try{
            shoppingCarRepositoryJpa.deleteById(id);
            responseDto.setCode("00");
            responseDto.setMessage("Objecto eliminado correctamente");

        }catch (Exception e){
            responseDto.setCode("02");
            responseDto.setMessage("No fue posible eliminar el objecto, contacte con soporte");
        }

        return responseDto;
    }

    public ResponseDto update(ItemCarDto itemCar, Integer idShoppingCar){
        ResponseDto responseDto = new ResponseDto<>();

        try {
            /* Tarea:
                implementar el metodo update, tenemos como parametros de entrada el id del carrito a actualizar
                y un item para agregar.
            */
            responseDto.setCode("00");
            responseDto.setMessage("Objecto actualizado correctamente");
        }catch (Exception e){
            responseDto.setCode("02");
            responseDto.setMessage("Error al actualizar el objeto, contacte con soporte");
        }
        return responseDto;
    }
}
