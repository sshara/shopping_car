package com.spring_course.shopping_car.infrastructure.persistence.repository;

import com.spring_course.shopping_car.infrastructure.persistence.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepositoryJpa extends JpaRepository<Item, Integer> {

    @Query("Select U from Item U where U.id= :id and U.description = :description")
    List<Item> findByShoppingCarIdAndDescription(@Param("id") Integer id, @Param("description") String description);

}
