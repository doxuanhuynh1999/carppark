package com.example.carpark.repository;

import com.example.carpark.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends JpaRepository<Car,String> {
//    @Query(value = "update car set car_color = ?1, car_type = ?2, company = ?3 where license_plate  = ?4 ",nativeQuery = true)
//    @Modifying
//    void updateCar(String caColor, String CarType, String company, String lisencePlate);
    Car findByLicensePlate(String licensePlate);
}
