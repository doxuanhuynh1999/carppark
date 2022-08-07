package com.example.carpark.service.bookingoffice;

import com.example.carpark.dto.BookingofficeDto;
import com.example.carpark.entity.Bookingoffice;
import com.example.carpark.entity.Car;
import com.example.carpark.form.BookingofficeForm;

import java.util.List;

public interface BookingOfficeService {
    List<BookingofficeDto> getBookingoffice();
    Bookingoffice addBookingoffice(BookingofficeForm bookingofficeForm);
    Bookingoffice updateBookingoffice(Long officeId, BookingofficeForm bookingofficeForm);
    public boolean deleteBookingoffice(Long officeId);
}
