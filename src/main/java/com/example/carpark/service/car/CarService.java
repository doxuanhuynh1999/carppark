package com.example.carpark.service.car;

import com.example.carpark.dto.CarDto;
import com.example.carpark.entity.Car;
import com.example.carpark.form.CarForm;

import java.util.List;

public interface CarService {
    List<CarDto> getCar();
    Car addCar(CarForm carForm);
    Car updateCar(String licensePlate,CarForm carForm);
    public boolean deleteCar(String licensePlate);
}
