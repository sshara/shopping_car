package com.spring_course.shopping_car.application.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="car")
public class Car implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator ="sequence_car")
    @SequenceGenerator(name = "sequence_car", allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    /*@ManyToOne(fetch =  FetchType.LAZY)
    private Venta venta;*/
}
