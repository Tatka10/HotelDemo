package com.example.HotelDemo;

import jdk.jfr.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class HotelService {
    List<Hotel> hotels = new ArrayList<>();


    public HotelService() {
        System.out.println("загружается сервис");
        hotels.add(new Hotel("5 stars", "GRAND HOTEL EMERALD"));
        hotels.add(new Hotel("4 stars", "COSMOS PRIBALTIYSKAYA "));
        hotels.add(new Hotel("4 stars", "CITITEL SAINT-PETERSBURG"));
        hotels.add(new Hotel("5 stars", "GRAND HOTEL EUROPA"));
        hotels.add(new Hotel("2 stars", "HOSTEL KROVATKA"));
        hotels.add(new Hotel("2 stars", "HOSTEL CENTR"));
    }

    public List<Hotel> getHotels() {
        return hotels;
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

    public List<Hotel> addHotel(String name, String category) {
        hotels.add(new Hotel(category, name));

        return hotels;
    }

    public List<Hotel> getHotelsByCategory(String category) {
        return hotels.stream().filter(p -> p.getCategory().equals(category)).toList();
    }

    public List<String> getCategories() {
        return hotels.stream().map(Hotel::getCategory).distinct().sorted().toList();
    }

}