package com.example.carpark.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "car")
public class Car {
    @Id
    @Column(name = "license_plate",length = 50)
    private String licensePlate;

    @Column(name = "car_color", length =11)
    private String carColor;

    @Column(name = "car_type", length =50)
    private String carType;

    @Column(name = "company", length =50)
    private String company;

    @ManyToOne()
    @JoinColumn(name = "park_id", nullable = false, foreignKey = @ForeignKey(name = "park_id"))
    @JsonBackReference
    private Parkinglot parkinglot;

    @OneToMany(cascade = CascadeType.ALL, mappedBy ="car")
    @JsonManagedReference
    private Set<Ticket> ticketCars;
    public Car() {
    }
}
