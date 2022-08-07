package com.example.carpark.controller;

import com.example.carpark.dto.BookingofficeDto;
import com.example.carpark.entity.Bookingoffice;
import com.example.carpark.entity.Trip;
import com.example.carpark.exception.ExistedExcepttion;
import com.example.carpark.exception.NotForeignKeyException;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.form.BookingofficeForm;
import com.example.carpark.service.bookingoffice.BookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BookingOfficeCoontroller {
    @Autowired
    private BookingOfficeService bookingOfficeService;
    @PostMapping(value = "/addBook")
    public ResponseEntity<Object> addBook(@RequestBody @Valid BookingofficeForm bookingofficeForm) throws ExistedExcepttion , NotForeignKeyException {
        bookingOfficeService.addBookingoffice(bookingofficeForm);
        return new ResponseEntity<>("add oke", HttpStatus.OK);
    }
    @GetMapping(value = "/getBook")
    public ResponseEntity<Object> getBook() {
        return new ResponseEntity<>(bookingOfficeService.getBookingoffice(),HttpStatus.OK);
    }
    @PutMapping(value = "/updateBook/{officeId}")
    public ResponseEntity<Object> updateBook(@PathVariable("officeId") Long officeId ,@RequestBody @Valid BookingofficeForm bookingofficeForm) throws NotFoundException {
        bookingOfficeService.updateBookingoffice(officeId, bookingofficeForm);
        return new ResponseEntity<>("update oke", HttpStatus.OK);
    }
    @DeleteMapping(value = "/deleteBook/{officeId}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("officeId") Long officeId) throws NotFoundException {
        bookingOfficeService.deleteBookingoffice(officeId);
        return new ResponseEntity<>("delete oke", HttpStatus.OK);
    }
}
