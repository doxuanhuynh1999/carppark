package com.example.carpark.service.ticket;

import com.example.carpark.dto.TicketDto;
import com.example.carpark.entity.Car;
import com.example.carpark.entity.Ticket;
import com.example.carpark.entity.Trip;
import com.example.carpark.form.TicketForm;

import java.util.List;

public interface TicketSerVice {
    List<TicketDto> getTicket();
    Ticket addTicket(TicketForm ticketForm);
    Ticket updateTicket(Long ticketId,TicketForm ticketForm);
    public boolean deleteTicket(long ticketId);
}
