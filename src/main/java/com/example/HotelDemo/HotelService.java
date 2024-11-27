package com.example.HotelDemo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class HotelService {
    List<Hotel> hotels = new ArrayList<>();
    List<String> listSearches = new ArrayList<>();

    public HotelService() {
        System.out.println("загружается сервис");
        hotels.add(new Hotel("5 stars", "EMERALD", "GrEmerald.jpg"));
        hotels.add(new Hotel("4 stars", "PRIBALTIYSKAYA", "Pribaltiiskaya.jpg"));
        hotels.add(new Hotel("4 stars", "SPETERSBURG", "SaintPeterburg.jpg"));
        hotels.add(new Hotel("5 stars", "EUROPA", "Europa.jpg"));
        hotels.add(new Hotel("2 stars", "KROVATKA", "Krovatka.jpeg"));
        hotels.add(new Hotel("2 stars", "CENTR", "Centrehotel.jpg"));
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
            if (Objects.equals(hotel.getName(), name.toUpperCase())) {
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
        hotels.add(new Hotel(category, name.toUpperCase()));

        return hotels;
    }

    public List<Hotel> getHotelsByCategory(String category) {
        return hotels.stream().filter(p -> p.getCategory().equals(category)).toList();
    }

    public List<String> getCategories() {
        return hotels.stream().map(Hotel::getCategory).distinct().sorted().toList();
    }

    public List<String> saveSearchHotels(String name) {
        listSearches.add(name);

        return listSearches;
    }

}