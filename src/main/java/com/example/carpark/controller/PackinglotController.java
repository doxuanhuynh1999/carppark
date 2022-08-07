package com.example.carpark.controller;

import com.example.carpark.dto.ParkinglotDto;
import com.example.carpark.entity.Parkinglot;
import com.example.carpark.exception.ExistedExcepttion;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.form.ParkinglotForm;
import com.example.carpark.service.packinglot.ServiceParkinglot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PackinglotController {
    @Autowired
    private ServiceParkinglot serviceParkinglot;
    @PostMapping(value = "/addParkinglot")
    public ResponseEntity<Object> addParkinglot(@RequestBody @Valid ParkinglotForm parkinglotForm) throws ExistedExcepttion {
        serviceParkinglot.addParkinglot(parkinglotForm);
        return new ResponseEntity<>("add oke", HttpStatus.OK);
    }
    @GetMapping(value = "/getParkinglot")
    public ResponseEntity<Object> getParkinglot() {
        return new ResponseEntity<>(serviceParkinglot.getParkinglots(),HttpStatus.OK);
    }
    @PutMapping(value = "/updateParkinglot/{id}")
    public ResponseEntity<Object> updateParkinglot(@PathVariable("id") Long id ,@RequestBody @Valid ParkinglotForm parkinglotForm) throws NotFoundException {
        serviceParkinglot.updateParkinglot(id, parkinglotForm);
        return new ResponseEntity<>("update oke", HttpStatus.OK);
    }
    @DeleteMapping(value = "/deleteParkinglot/{id}")
    public ResponseEntity<Object> deleteParkinglot(@PathVariable("id") Long id) {
        serviceParkinglot.deleteParkinglot(id);
        return new ResponseEntity<>("delete oke", HttpStatus.OK);
    }

}
