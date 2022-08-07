package com.example.carpark.service.ticket;

import com.example.carpark.dto.TicketDto;
import com.example.carpark.entity.Car;
import com.example.carpark.entity.Ticket;
import com.example.carpark.entity.Trip;
import com.example.carpark.exception.ExistedExcepttion;
import com.example.carpark.exception.NotForeignKeyException;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.form.TicketForm;
import com.example.carpark.repository.CarRepository;
import com.example.carpark.repository.TicketRepository;
import com.example.carpark.repository.TripRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketIpmService implements TicketSerVice{
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<TicketDto> getTicket() {

        return ticketRepository.findAll().stream()
                .map(data -> {
                    TicketDto ticketDto = new TicketDto();
                    BeanUtils.copyProperties(data,ticketDto);
                    ticketDto.setLicensePlate(data.getCar().getLicensePlate());
                    ticketDto.setTripId(data.getTripTicket().getTripId());
                    return ticketDto;
                }).collect(Collectors.toList());
    }

    @Override
    public Ticket addTicket(TicketForm ticketForm) {
        Car car = carRepository.findByLicensePlate(ticketForm.getLicensePlate());
        Trip trip = tripRepository.findByTripId(ticketForm.getTripId());
        if (car == null || trip == null){
            throw new NotForeignKeyException("ForeignKey not existed");
        }
       Ticket ticket = new Ticket();
        ticket.setCar(car);
        ticket.setTripTicket(trip);
        BeanUtils.copyProperties(ticketForm,ticket);
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicket(Long ticketId, TicketForm ticketForm) {
        Ticket ticket1 = ticketRepository.findById(ticketId).stream().findFirst().orElse(null);
        if (ticket1 == null) {
            throw new NotFoundException("Not found ticket for ticketId " + ticketId);
        }
        BeanUtils.copyProperties(ticketForm,ticket1);
        ticket1.setTicketId(ticketId);
        return ticketRepository.save(ticket1);
    }

    @Override
    public boolean deleteTicket(long ticketId) {
        Ticket ticket1 = ticketRepository.findById(ticketId).stream().findFirst().orElse(null);
        if (ticket1 == null) {
            throw new NotFoundException("Not found ticket for ticketId " + ticketId);
        }
        ticketRepository.deleteById(ticketId);
        return true;
    }
}
