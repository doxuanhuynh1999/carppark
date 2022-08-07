package com.example.carpark.controller;

import com.example.carpark.dto.TicketDto;
import com.example.carpark.entity.Ticket;
import com.example.carpark.entity.Trip;
import com.example.carpark.exception.ExistedExcepttion;
import com.example.carpark.exception.NotForeignKeyException;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.form.TicketForm;
import com.example.carpark.service.ticket.TicketSerVice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TicketController {
    @Autowired
    private TicketSerVice ticketService;
    @PostMapping(value = "/addTicket")
    public ResponseEntity<Object> addTickket(@RequestBody @Valid TicketForm ticketForm) throws ExistedExcepttion, NotForeignKeyException {
        ticketService.addTicket(ticketForm);
        return new ResponseEntity<>("add oke", HttpStatus.OK);
    }
    @GetMapping(value = "/getTicket")
    public ResponseEntity<Object> getTicket() {
        return new ResponseEntity<>(ticketService.getTicket(),HttpStatus.OK);
    }
    @PutMapping(value = "/updateTicket/{ticketId}")
    public ResponseEntity<Object> updateTicket(@PathVariable("ticketId") Long ticketId ,@RequestBody @Valid TicketForm ticketForm) throws NotFoundException {
        ticketService.updateTicket(ticketId, ticketForm);
        return new ResponseEntity<>("update oke", HttpStatus.OK);
    }
    @DeleteMapping(value = "/deleteTicket/{ticketId}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("ticketId") Long ticketId) throws NotFoundException {
        ticketService.deleteTicket(ticketId);
        return new ResponseEntity<>("delete oke", HttpStatus.OK);
    }
}
