package com.example.carpark.controller;

import com.example.carpark.dto.TripDto;
import com.example.carpark.entity.Trip;
import com.example.carpark.exception.ExistedExcepttion;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.form.TripForm;
import com.example.carpark.service.trip.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TripController {
    @Autowired
    private TripService tripService;
    @PostMapping(value = "/addTrip")
    public ResponseEntity<Object> addTrip(@RequestBody @Valid TripForm tripForm) throws ExistedExcepttion {
        tripService.addTrip(tripForm);
        return new ResponseEntity<>("add oke", HttpStatus.OK);
    }
    @GetMapping(value = "/getTrip")
    public ResponseEntity<Object> getTrip() {
        return new ResponseEntity<>(tripService.getTrip(),HttpStatus.OK);
    }
    @PutMapping(value = "/updateTrip/{tripId}")
    public ResponseEntity<Object> updateTrip(@PathVariable("tripId") Long tripId ,@RequestBody @Valid TripForm tripForm) throws NotFoundException {
        tripService.updateTrip(tripId, tripForm);
        return new ResponseEntity<>("update oke", HttpStatus.OK);
    }
    @DeleteMapping(value = "/deleteTrip/{tripId}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("tripId") Long tripId) throws NotFoundException {
        tripService.deleteTrip(tripId);
        return new ResponseEntity<>("delete oke", HttpStatus.OK);
    }
}
