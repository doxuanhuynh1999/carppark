package com.example.carpark.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "parkinglot")
public class Parkinglot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "park_id", length = 20)
    private Long parkId;

    @Column(name = "park_area", length = 20 )
    private Long parkArea;

    @Column(name = "park_name", length = 50)
    private String parkName;

    @Column(name = "park_place", length =11)
    private String parkPlace;

    @Column(name = "park_price", length =20)
    private Long parkPrice;

    @Column(name = "park_status",length = 50)
    private String parkStatus;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "parkinglot")
    @JsonManagedReference
    private List<Car> cars;

    public Parkinglot() {
    }
}
