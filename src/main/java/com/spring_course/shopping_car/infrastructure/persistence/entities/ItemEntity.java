package com.spring_course.shopping_car.infrastructure.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="items")
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator ="sequence_item")
    @SequenceGenerator(name = "sequence_item", allocationSize = 1)
    @Column(name = "id")
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
    @JoinColumn(name="id_shopping_car", nullable = false)
    private ShoppingCarEntity shoppingCar;

}
