package com.spring_course.shopping_car.infrastructure.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="items")
public class Item{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator ="sequence_item")
    @SequenceGenerator(name = "sequence_item", allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "description")
    private String description;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_shopping_car")
    private ShoppingCar shoppingCar;
}
