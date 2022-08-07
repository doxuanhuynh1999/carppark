package com.example.carpark.service.trip;

import com.example.carpark.dto.TripDto;
import com.example.carpark.entity.Trip;
import com.example.carpark.form.TripForm;

import java.util.List;

public interface TripService {
    List<TripDto> getTrip();
    Trip addTrip(TripForm tripForm);
    Trip updateTrip(long tripId,TripForm tripForm);
    public boolean deleteTrip(long tripId);
}
