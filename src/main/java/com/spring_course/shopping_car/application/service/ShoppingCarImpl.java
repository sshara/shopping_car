package com.spring_course.shopping_car.application.service;

import com.spring_course.shopping_car.application.dto.ItemCarDto;
import com.spring_course.shopping_car.application.dto.ResponseDto;
import com.spring_course.shopping_car.application.dto.ShoppingcarDto;
import com.spring_course.shopping_car.application.entities.Car;
import com.spring_course.shopping_car.application.entities.Recibo;
import com.spring_course.shopping_car.application.entities.Venta;
import com.spring_course.shopping_car.application.repository.IReciboRepository;
import com.spring_course.shopping_car.application.utils.ShoppingCarUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCarImpl implements ShoppingCarService {

    @Autowired
    private ShoppingCarUtils shoppingCarUtils;

    @Autowired
    private IReciboRepository reciboRepository;


    @Override
    public ResponseDto getShoppingCarById(int id) {

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

        return responseDto;
    }

    @Override
    public ResponseDto createShoppingCar(ShoppingcarDto shoppingCar) {

        ResponseEntity<ResponseDto> response;
        ResponseDto responseDto = new ResponseDto<>();
        try {
            Car carItem;
            List<Car> items = new ArrayList<>();
            Venta venta;
            List<Venta> ventas =  new ArrayList<>();
            Recibo recibo = new Recibo();
            recibo.setNombre("Pepito Perez");
            for(ItemCarDto itemsCar : shoppingCar.getItems()){
                items.clear();
                carItem = new Car();
                carItem.setName(itemsCar.getName());
                carItem.setPrice(itemsCar.getPrice());
                items.add(carItem);
                venta = new Venta();
                venta.setAmount(itemsCar.getAmount());
                venta.setDescription(itemsCar.getDescription());
                venta.setCars(items);
                ventas.add(venta);
            }

            recibo.setVentas(ventas);

            reciboRepository.save(recibo);


            responseDto.setCode("00");
            responseDto.setMessage("Objeto creado correctamente");
            response = new ResponseEntity(responseDto, HttpStatus.OK);
            shoppingCarUtils.converFromDollarToCop(shoppingCar.getItems().get(0).getPrice());

        }catch (Exception e){
            responseDto.setCode("02");
            responseDto.setMessage("Error al crear el objeto, contacte con soporte");
            response = new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }

        return responseDto;
    }

    public List<Recibo> getAll(){
        return reciboRepository.findAll();
    }

    public List<Recibo> getByDescripcion(String descripcion){
        return reciboRepository.findByDescription(descripcion);
    }

    public boolean delete(Integer id){
        try{
            reciboRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Recibo update(Recibo recibo){
        return reciboRepository.save(recibo);
    }
}
