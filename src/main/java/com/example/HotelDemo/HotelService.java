package com.example.HotelDemo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class HotelService {
    List<Hotel> hotels = new ArrayList<>();

    public List<Hotel> getHotels() {
        return hotels;
    }

    public HotelService(List<Hotel> hotels) {
        hotels.add(new Hotel(1, 5, "GRAND HOTEL EMERALD"));
        hotels.add(new Hotel(2, 4, "COSMOS PRIBALTIYASKAYA "));
        hotels.add(new Hotel(3, 4, "CITITEL SAINTPETERSBURG"));
        hotels.add(new Hotel(4, 5, "GRAND HOTEL EUROPA"));
    }

    public Hotel getHotelById(int id) {
        for (Hotel hotel : hotels) {
            if (hotel.getId() == id) {
                return hotel;
            }
        }
        return null;
    }

    public Hotel getHotelByName(String name) {
        for (Hotel hotel : hotels) {
            if (Objects.equals(hotel.getName(), name)) {
                return hotel;
            }
        }

        return null;
    }

    public void removeById(int id) {
        Hotel hotel = getHotelById(id);
        if (hotel != null)
            hotels.remove(hotel);
    }
}