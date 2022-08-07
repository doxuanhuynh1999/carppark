package com.example.carpark.repository;

import com.example.carpark.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;

public interface TripRepository extends JpaRepository<Trip,Long> {
//    @Query(value = "update trip set booked_ticket_number = ?1, car_type = ?2,departure_date =?3,departure_time =?4,destination = ?5,driver = ?6,maximum_online_ticket_number = ?7 where trip_id = ?8", nativeQuery = true)
//    @Modifying
//    void updateTrip(Integer bookedTicketNumber, String carType, LocalDate departureDate, LocalTime departureTime, String destination,String driver, Integer maximumOnlineTicketNumber, Long tripId);
    Trip findByTripId(long tripId);
}
