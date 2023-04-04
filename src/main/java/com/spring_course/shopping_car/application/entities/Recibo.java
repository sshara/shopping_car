package com.spring_course.shopping_car.application.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="recibo")
public class Recibo implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator ="sequence_recibo")
    @SequenceGenerator(name = "sequence_recibo", allocationSize = 1)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;


    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "id_recibo")
    private List<Venta> ventas = new ArrayList<>();

}
