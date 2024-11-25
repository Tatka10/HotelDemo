package com.example.HotelDemo;

public class Hotel {
    String name;
    int category;
    int id;

    public Hotel(int id, int category, String name) {
        this.id = id;
        this.category = category;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getCategory() {
        return category;
    }
}

