package com.example.HotelDemo;


public class Hotel {
    String name;
    int category;
    int id;

    public Hotel( int category, String name) {
        int counter = 0;
        counter++;
        this.id = counter;
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

