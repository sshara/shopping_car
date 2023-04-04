package com.spring_course.shopping_car.application.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="venta")
public class Venta implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator ="sequence_venta")
    @SequenceGenerator(name = "sequence_venta", allocationSize = 1)
    private Integer id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "id_venta")
    private List<Car> cars = new ArrayList<>();

    /*@ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "id_recibo")
    private Recibo recibo;*/
}
