package com.spring_course.shopping_car.infrastructure.persistence.repository;

import com.spring_course.shopping_car.infrastructure.persistence.entities.ShoppingCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCarRepositoryJpa extends JpaRepository<ShoppingCarEntity, Integer> {

}
