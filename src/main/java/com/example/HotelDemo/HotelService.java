package com.example.HotelDemo;

import org.springframework.stereotype.Component;
import org.w3c.dom.html.HTMLObjectElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class HotelService {
    List<Hotel> hotels = new ArrayList<>();



    public HotelService() {
        System.out.println("загружается сервис");
        hotels.add(new Hotel(1, "GRAND HOTEL EMERALD"));
        hotels.add(new Hotel(2, "COSMOS PRIBALTIYSKAYA "));
        hotels.add(new Hotel(3, "CITITEL SAINTPETERSBURG"));
        hotels.add(new Hotel(4, "GRAND HOTEL EUROPA"));
    }
    public List<Hotel> getHotels() {
        return hotels;}

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
    public List<Hotel> addHotel(String name, String category){
        hotels.add(new Hotel(Integer.parseInt(category), name));

    return hotels;}
}