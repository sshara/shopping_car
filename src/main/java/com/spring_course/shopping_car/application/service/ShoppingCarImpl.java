package com.spring_course.shopping_car.application.service;

import com.spring_course.shopping_car.application.dto.ItemCarDto;
import com.spring_course.shopping_car.application.dto.ResponseDto;
import com.spring_course.shopping_car.application.dto.ShoppingcarDto;
import com.spring_course.shopping_car.infrastructure.persistence.entities.Item;
import com.spring_course.shopping_car.infrastructure.persistence.entities.ShoppingCar;
import com.spring_course.shopping_car.infrastructure.persistence.repository.ShoppingCarRepositoryJpa;
import com.spring_course.shopping_car.application.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCarImpl implements ShoppingCarService {

    @Autowired
    private Utils shoppingCarUtils;

    @Autowired
    private ShoppingCarRepositoryJpa shoppingCarRepositoryJpa;


    @Override
    public ResponseDto getShoppingCarById(int id) {

        ResponseDto responseDto = new ResponseDto<ShoppingcarDto>();

        try {

            Optional<ShoppingCar> shoppingCarOptional = shoppingCarRepositoryJpa.findById(id);
            assert shoppingCarOptional.isPresent();

            ShoppingCar shoppingCar = shoppingCarOptional.get();
            assert !shoppingCar.getItems().isEmpty();

            List<ItemCarDto> items = new ArrayList<>();
            for (Item item:shoppingCar.getItems()) {
                ItemCarDto itemCarDto = new ItemCarDto(item.getName(),
                        item.getAmount(),
                        item.getPrice(),
                        item.getDescription());
                items.add(itemCarDto);
            }
            responseDto.setData(new ShoppingcarDto(String.valueOf(shoppingCar.getId()), items));
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

            List<ShoppingCar> shoppingCars = shoppingCarRepositoryJpa.findAll();
            List<ShoppingcarDto> shoppingcarDtos = new ArrayList<>();
            assert !shoppingCars.isEmpty();
            for (ShoppingCar shoppingcar: shoppingCars) {

                assert !shoppingcar.getItems().isEmpty();
                List<ItemCarDto> items = new ArrayList<>();
                for (Item item:shoppingcar.getItems()) {
                    ItemCarDto itemCarDto = new ItemCarDto(item.getName(),
                            item.getAmount(),
                            item.getPrice(),
                            item.getDescription());
                    items.add(itemCarDto);
                }
                shoppingcarDtos.add(new ShoppingcarDto(String.valueOf(shoppingcar.getId()), items));
            }
            responseDto.setData(shoppingcarDtos);
            responseDto.setCode("00");
            responseDto.setMessage("Objecto eliminado correctamente");

        }catch (Exception e){
            responseDto.setCode("02");
            responseDto.setMessage("No fue posible eliminar el objecto, contacte con soporte");
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
