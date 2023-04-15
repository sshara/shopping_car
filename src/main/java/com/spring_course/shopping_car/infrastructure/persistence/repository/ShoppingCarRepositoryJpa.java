package com.spring_course.shopping_car.infrastructure.persistence.repository;

import com.spring_course.shopping_car.infrastructure.persistence.entities.ShoppingCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCarRepositoryJpa extends JpaRepository<ShoppingCar, Integer> {

}
