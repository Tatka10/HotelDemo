package com.example.HotelDemo;


public class Hotel {

    String name;
    String category;
    int id;
    static int counter = 1;

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", id=" + id +
                '}';
    }


    public Hotel(String category, String name) {

        this.category = category;
        this.name = name;
        this.id = counter;
        counter++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }
}

