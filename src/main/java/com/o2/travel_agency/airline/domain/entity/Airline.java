package com.o2.travel_agency.airline.domain.entity;

public class Airline {
    private int id;
    private String name;

    public Airline() {
    }

    public Airline(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " id: " + id + " | name: " + name;
    }

}
