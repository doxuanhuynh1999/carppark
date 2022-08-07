package com.example.carpark.service.car;

import com.example.carpark.dto.CarDto;
import com.example.carpark.entity.Car;
import com.example.carpark.entity.Parkinglot;
import com.example.carpark.exception.ExistedExcepttion;
import com.example.carpark.exception.NotForeignKeyException;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.form.CarForm;
import com.example.carpark.repository.CarRepository;
import com.example.carpark.repository.ParkinglotRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarIpmService implements CarService{
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ParkinglotRepository parkinglotRepository;

    @Override
    public List<CarDto> getCar() {
        return carRepository.findAll().stream()
                .map(data -> {
                    CarDto carDto = new CarDto();
                    BeanUtils.copyProperties(data, carDto);
                    carDto.setParkingId(data.getParkinglot().getParkId());
                    return carDto;
                }).collect(Collectors.toList());
    }
    @Override
    public Car addCar(CarForm carForm) {
        Parkinglot parkinglot1 = parkinglotRepository.findByParkId(carForm.getParkingId()); // kiem tra xem bien so co hay khong
        Car car1 = carRepository.findById(carForm.getLicensePlate()).stream().findFirst().orElse(null);
        if(car1 != null){
            throw new ExistedExcepttion("existed car with license plate " + carForm.getLicensePlate());
        }
        if(parkinglot1 == null){
            throw new NotForeignKeyException("ForeignKey not existed");
        }
        Car car = new Car();
        car.setParkinglot(parkinglot1);
        BeanUtils.copyProperties(carForm, car);
        return carRepository.save(car);
    }
    @Override

    public Car updateCar(String licensePlate, CarForm carForm) {
        Car car1 = carRepository.findById(licensePlate).stream().findFirst().orElse(null);
        if(car1 == null){
            throw new NotFoundException("Not found car for" + licensePlate);
        }
        BeanUtils.copyProperties(carForm, car1);
        car1.setLicensePlate(licensePlate);
        return carRepository.save(car1);
    }
    @Override
    public boolean deleteCar(String licensePlate) {
        Car car1 = carRepository.findById(licensePlate).stream().findFirst().orElse(null);
        if(car1 == null){
            throw new NotFoundException("Not found car for" + licensePlate);
        }
        carRepository.deleteById(licensePlate);
        return true;
    }
}
