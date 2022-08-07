package com.example.carpark.service.bookingoffice;

import com.example.carpark.dto.BookingofficeDto;
import com.example.carpark.entity.Bookingoffice;
import com.example.carpark.entity.Trip;
import com.example.carpark.exception.ExistedExcepttion;
import com.example.carpark.exception.NotForeignKeyException;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.form.BookingofficeForm;
import com.example.carpark.repository.BookingOfficeRepository;
import com.example.carpark.repository.TripRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingOfficeIpmService implements BookingOfficeService{
    @Autowired
    private BookingOfficeRepository bookingOfficeRepository;
    @Autowired
    private TripRepository tripRepository;
    @Override
    public List<BookingofficeDto> getBookingoffice() {
        return bookingOfficeRepository.findAll().stream()
                .map(data -> {
                    BookingofficeDto bookingofficeDto = new BookingofficeDto();
                    BeanUtils.copyProperties(data, bookingofficeDto);
                    bookingofficeDto.setTripId(data.getTripBooking().getTripId());
                    return bookingofficeDto;
                }).collect(Collectors.toList());
    }
    @Override
    public Bookingoffice addBookingoffice(BookingofficeForm bookingofficeForm) {
        Trip trip = tripRepository.findByTripId(bookingofficeForm.getTripId());
        if (trip == null){
            throw new NotForeignKeyException("ForeignKey not existed");
        }
        Bookingoffice bookingoffice = new Bookingoffice();
        bookingoffice.setTripBooking(trip);
        BeanUtils.copyProperties(bookingofficeForm, bookingoffice);
        return bookingOfficeRepository.save(bookingoffice);
    }
    @Override
    public Bookingoffice updateBookingoffice(Long officeId, BookingofficeForm bookingofficeForm) {
        Bookingoffice bookingoffice1 = bookingOfficeRepository.findById(officeId).stream().findFirst().orElse(null);
        if (bookingoffice1 == null) {
            throw new NotFoundException("Not found bookingoffice for " + bookingofficeForm.getOfficeId());
        }
        BeanUtils.copyProperties(bookingofficeForm, bookingoffice1);
        bookingoffice1.setOfficeId(officeId);
        return bookingOfficeRepository.save(bookingoffice1);
    }
    @Override
    public boolean deleteBookingoffice(Long officeId) {
        Bookingoffice bookingoffice1 = bookingOfficeRepository.findById(officeId).stream().findFirst().orElse(null);
        if (bookingoffice1 == null) {
            throw new NotFoundException("Not found bookingoffice for " + officeId);
        }
        bookingOfficeRepository.deleteById(officeId);
        return true;
    }
}
