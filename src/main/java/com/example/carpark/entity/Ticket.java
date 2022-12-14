package com.example.carpark.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name = "booking_time")
    private LocalTime bookingTime;

    @Column(name = "customer_name")
    private String customerName;
    @ManyToOne()
    @JoinColumn(name = "license_plate",nullable = false,foreignKey = @ForeignKey(name = "license_plate"))
    @JsonBackReference
    private Car car;

    @ManyToOne()
    @JoinColumn(name = "trip_id_ticket",nullable = false,foreignKey = @ForeignKey(name = "trip_id_ticket"))
    @JsonBackReference
    private Trip tripTicket;

    public Ticket() {
    }
}
