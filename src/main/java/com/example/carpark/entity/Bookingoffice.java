package com.example.carpark.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "bookingoffice")
public class Bookingoffice {
    @Id
    @Column(name = "office_id",length =20)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long officeId;

    @Column(name = "end_contract_deadline")
    private LocalDate endContractDeadline;

    @Column(name = "office_name",length = 50)
    private String officeName;

    @Column(name = "office_phone", length = 11)
    private String officePhone;

    @Column(name = "office_place",length = 50)
    private String officePlace;

    @Column(name = "office_price",length = 20)
    private Long officePrice;

    @Column(name = "start_contract_deadline")
    private LocalDate startContractDeadline;

    @ManyToOne()
    @JoinColumn(name = "trip_id",nullable = false, foreignKey = @ForeignKey(name = "trip_id"))
    @JsonBackReference
    private Trip tripBooking;
    public Bookingoffice() {
    }
}
