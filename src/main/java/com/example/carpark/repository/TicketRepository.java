package com.example.carpark.repository;

import com.example.carpark.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
//    @Query(value = "update ticket set booking_time =?1, customer_name =?2 where ticket_id = ?3",nativeQuery = true)
//    @Modifying
//    void updateticket(LocalTime bookingTime, String customerName, Long ticketId);
}
