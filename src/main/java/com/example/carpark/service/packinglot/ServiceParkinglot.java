package com.example.carpark.service.packinglot;

import com.example.carpark.dto.ParkinglotDto;
import com.example.carpark.entity.Parkinglot;
import com.example.carpark.form.ParkinglotForm;

import java.util.List;

public interface ServiceParkinglot {
    List<ParkinglotDto> getParkinglots();
    Parkinglot addParkinglot(ParkinglotForm parkinglotForm);
    Parkinglot updateParkinglot(Long id,ParkinglotForm parkinglotForm);
    public boolean deleteParkinglot(Long id);
}
