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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCarImpl implements ShoppingCarService {

    @Autowired
    private ShoppingCarRepositoryJpa shoppingCarRepositoryJpa;

    @Autowired
    private ItemRepositoryJpa itemRepositoryJpa;

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

    @Override
    public ResponseDto createShoppingCar(ShoppingcarDto shoppingCar) {
        ResponseDto responseDto = new ResponseDto<>();
        try {

            ShoppingCarEntity shoppingCarEntity = shoppingCarMapper.fromShoppingCarDto(shoppingCar);
            shoppingCarRepositoryJpa.save(shoppingCarEntity);
            itemRepositoryJpa.saveAll(shoppingCarEntity.getItems());
            responseDto.setCode("00");
            responseDto.setMessage("Objecto creado correctamente");

        }catch (Exception e){
            responseDto.setCode("02");
            responseDto.setMessage("Error al crear el objeto, contacte con soporte");
            e.printStackTrace();
        }

        return responseDto;
    }

    public ResponseDto update(ItemCarDto itemCar, Integer idShoppingCar){
        ResponseDto responseDto = new ResponseDto<>();

        try {
            Optional<ShoppingCarEntity> shoppingCarEntity = shoppingCarRepositoryJpa.findById(idShoppingCar);
            assert shoppingCarEntity.isPresent();
            ShoppingcarDto shoppingcarDto = shoppingCarMapper.toShoppingCarDto(shoppingCarEntity.get());
            if(shoppingcarDto.getItems().contains(itemCar)){
                responseDto.setCode("03");
                responseDto.setMessage("El item ya existe en el carrito");
            }else{
                shoppingcarDto.getItems().add(itemCar);
                ShoppingCarEntity shoppingCar = shoppingCarMapper.fromShoppingCarDto(shoppingcarDto);
                shoppingCarRepositoryJpa.save(shoppingCar);
                //itemRepositoryJpa.saveAll(shoppingCar.getItems());
                responseDto.setCode("00");
                responseDto.setMessage("Objecto actualizado correctamente");
            }

        }catch (Exception e){
            responseDto.setCode("02");
            responseDto.setMessage("Error al actualizar el objeto, contacte con soporte");
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
}
