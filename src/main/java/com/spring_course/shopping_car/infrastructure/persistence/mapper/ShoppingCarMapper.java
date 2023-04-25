package com.spring_course.shopping_car.infrastructure.persistence.mapper;

import com.spring_course.shopping_car.application.dto.ItemCarDto;
import com.spring_course.shopping_car.application.dto.ShoppingcarDto;
import com.spring_course.shopping_car.infrastructure.persistence.entities.ItemEntity;
import com.spring_course.shopping_car.infrastructure.persistence.entities.ShoppingCarEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingCarMapper {

    @Mapping(source = "id", target = "id", ignore = true)
    @BeanMapping(qualifiedByName = "FromShoppingCarDto")
    ShoppingCarEntity fromShoppingCarDto(ShoppingcarDto shoppingcarDto);

    ShoppingcarDto toShoppingCarDto(ShoppingCarEntity shoppingCarEntity);
    List<ShoppingcarDto> toShoppingCarDto(List<ShoppingCarEntity> shoppingCarEntity);

    @Named("FromShoppingCarDto")
    @AfterMapping
    default void setShoppingCar(@MappingTarget ShoppingCarEntity shoppingCarEntity) {
        shoppingCarEntity.getItems().forEach((item) -> {
            item.setShoppingCar(shoppingCarEntity);
        });
    }

}
