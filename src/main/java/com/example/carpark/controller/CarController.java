package com.example.carpark.controller;

import com.example.carpark.dto.CarDto;
import com.example.carpark.entity.Car;
import com.example.carpark.exception.ExistedExcepttion;
import com.example.carpark.exception.NotForeignKeyException;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.form.CarForm;
import com.example.carpark.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CarController {
    @Autowired
    private CarService carService;
    @PostMapping(value = "/addCar")
    public ResponseEntity<Object> addCar( @RequestBody @Valid CarForm carForm) throws ExistedExcepttion, NotForeignKeyException {
        carService.addCar(carForm);
        return new ResponseEntity<>("add oke", HttpStatus.OK);
    }
    @GetMapping(value = "/getCar")
    public ResponseEntity<Object> getCar() {
        return new ResponseEntity<>(carService.getCar(),HttpStatus.OK);
    }
    @PutMapping(value = "/updateCar/{lisencePlate}")
    public ResponseEntity<Object> updateCar(@PathVariable("lisencePlate") String lisencePlate ,@RequestBody @Valid CarForm carForm) throws NotFoundException {
        carService.updateCar(lisencePlate, carForm);
        return new ResponseEntity<>("update oke", HttpStatus.OK);
    }
    @DeleteMapping(value = "/deleteCar/{lisencePlate}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("lisencePlate") String lisencePlate) throws NotFoundException {
        carService.deleteCar(lisencePlate);
        return new ResponseEntity<>("delete oke", HttpStatus.OK);
    }
}
