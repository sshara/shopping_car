package com.spring_course.shopping_car.infrastructure.persistence.repository;

import com.spring_course.shopping_car.infrastructure.persistence.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepositoryJpa extends JpaRepository<ItemEntity, Integer> {

    @Query("Select U from ItemEntity U where U.id= :id and U.description = :description")
    List<ItemEntity> findByShoppingCarIdAndDescription(@Param("id") Integer id, @Param("description") String description);

}
