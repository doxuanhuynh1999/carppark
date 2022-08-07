package com.example.carpark.service.trip;

import com.example.carpark.dto.TripDto;
import com.example.carpark.entity.Trip;
import com.example.carpark.exception.ExistedExcepttion;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.form.TripForm;
import com.example.carpark.repository.TripRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripIpm implements TripService{
    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<TripDto> getTrip() {
        return tripRepository.findAll().stream()
                .map(data -> {
                    TripDto tripDto = new TripDto();
                    BeanUtils.copyProperties(data, tripDto);
                    return tripDto;
                }).collect(Collectors.toList());
    }
    @Override
    public Trip addTrip(TripForm tripForm) {
        Trip trip = new Trip();
        BeanUtils.copyProperties(tripForm, trip);
        return tripRepository.save(trip);
    }
    @Override

    public Trip updateTrip(long tripId, TripForm tripForm) {
        Trip trip1 = tripRepository.findById(tripId).stream().findFirst().orElse(null);
        if (trip1 == null) {
            throw new NotFoundException("not  found trip for" + tripForm.getTripId());
        }
        BeanUtils.copyProperties(tripForm,trip1);
        trip1.setTripId(tripId);
        return  tripRepository.save(trip1);
    }
    @Override
    public boolean deleteTrip(long tripId) {
        Trip trip1 = tripRepository.findById(tripId).stream().findFirst().orElse(null);
        if (trip1 == null) {
            throw new NotFoundException("not  found trip for" + tripId);
        }
        tripRepository.deleteById(tripId);
        return true;
    }
}
