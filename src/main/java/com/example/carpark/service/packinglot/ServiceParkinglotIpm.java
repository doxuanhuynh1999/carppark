package com.example.carpark.service.packinglot;

import com.example.carpark.dto.ParkinglotDto;
import com.example.carpark.entity.Parkinglot;
import com.example.carpark.exception.ExistedExcepttion;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.form.ParkinglotForm;
import com.example.carpark.repository.ParkinglotRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServiceParkinglotIpm implements ServiceParkinglot {
    @Autowired
    private ParkinglotRepository parkinglotRepository;

    @Override
    public List<ParkinglotDto> getParkinglots() {
        return parkinglotRepository.findAll().stream()
                .map(data -> {
                    ParkinglotDto parkinglotDto = new ParkinglotDto();
                    BeanUtils.copyProperties(data, parkinglotDto);
                    return parkinglotDto;
                })
                .collect(Collectors.toList());
    }
    @Override
    public Parkinglot addParkinglot(ParkinglotForm parkinglotForm) {
        Parkinglot parkinglot = new Parkinglot();
        BeanUtils.copyProperties(parkinglotForm,parkinglot);
        return parkinglotRepository.save(parkinglot);
    }
    @Override
    public Parkinglot updateParkinglot(Long id,ParkinglotForm parkinglotForm) {
        Parkinglot parkinglot1 = parkinglotRepository.findById(id).stream().findFirst().orElse(null);
        if (parkinglot1 == null){
            throw new NotFoundException("Not foundparkinglot for " + id);
        }
        BeanUtils.copyProperties(parkinglotForm,parkinglot1);
        parkinglot1.setParkId(id);
        return parkinglotRepository.save(parkinglot1);
    }
    @Override
    public boolean deleteParkinglot(Long id) {
        Parkinglot parkinglot1 = parkinglotRepository.findById(id).stream().findFirst().orElse(null);
        if (parkinglot1 == null){
            throw new NotFoundException("Not foundparkinglot for " + id);
        }
         parkinglotRepository.deleteById(id);
        return true;
    }
}
