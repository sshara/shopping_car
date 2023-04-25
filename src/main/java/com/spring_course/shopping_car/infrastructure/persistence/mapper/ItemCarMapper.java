package com.spring_course.shopping_car.infrastructure.persistence.mapper;

import com.spring_course.shopping_car.application.dto.ItemCarDto;
import com.spring_course.shopping_car.infrastructure.persistence.entities.ItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemCarMapper {


    ItemEntity fromItemCarDto(ItemCarDto itemCarDto);

    ItemCarDto toItemCarDto(ItemEntity itemEntity);
    List<ItemCarDto> toItemCarDto(List<ItemEntity> itemEntityList);

    default Double toDouble(String str){
        return Double.parseDouble(str);
    }
}
