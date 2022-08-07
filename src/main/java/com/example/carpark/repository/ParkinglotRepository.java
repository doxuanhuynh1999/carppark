package com.example.carpark.repository;

import com.example.carpark.entity.Parkinglot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ParkinglotRepository extends JpaRepository<Parkinglot,Long> {
//    @Query(value = "update parkinglot set park_area = ?1, park_name = ?2, park_place = ?3, park_price = ?4, park_status = ?5 where park_id = ?6",nativeQuery = true)
//    @Modifying
//    void updateParkinglot(Long parkArea, String parkName, String parkPlace, long parkPrice, String parkStatus,Long id);
    Parkinglot findByParkId(Long parkId);
}
