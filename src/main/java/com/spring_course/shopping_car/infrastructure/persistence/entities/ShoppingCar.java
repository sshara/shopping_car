package com.spring_course.shopping_car.infrastructure.persistence.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="shopping_cars")
public class ShoppingCar implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator ="sequence_shopping_car")
    @SequenceGenerator(name = "sequence_shopping_car", allocationSize = 1)
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "shoppingCar")
    @ToString.Exclude
    private List<Item> items;

}
