package com.example.carpark.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "trip")
public class Trip {
    @Id
    @Column(name = "trip_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId;

    @Column(name = "booked_ticket_number")
    private Integer bookedTicketNumber;

    @Column(name = "car_type",length =11)
    private String carType;

    @Column(name = "departure_date")
    private LocalDate departureDate;

    @Column(name = "departure_time")
    private LocalTime departureTime;

    @Column(name = "destination",length =50)
    private String destination;

    @Column(name = "driver",length = 11)
    private String driver;

    @Column(name = "maximum_online_ticket_number")
    private Integer maximumOnlineTicketNumber;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tripTicket")
    @JsonManagedReference
    private List<Ticket> tiketTrips;

    @OneToMany(cascade = CascadeType.ALL,mappedBy ="tripBooking")
    @JsonManagedReference
    private List<Bookingoffice> bookingOffice;

    public Trip() {
    }
}
