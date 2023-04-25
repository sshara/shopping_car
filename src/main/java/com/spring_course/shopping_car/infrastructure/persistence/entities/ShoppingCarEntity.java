package com.spring_course.shopping_car.infrastructure.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="shopping_cars")
public class ShoppingCarEntity{



    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator ="sequence_shopping_car")
    @SequenceGenerator(name = "sequence_shopping_car", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "shoppingCar", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<ItemEntity> items;

}
