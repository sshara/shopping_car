package com.spring_course.shopping_car.application.repository;

import com.spring_course.shopping_car.application.entities.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReciboRepository extends JpaRepository<Recibo, Integer> {
}
