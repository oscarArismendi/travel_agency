package com.o2.travel_agency.airport.domain.entity;

public class Airport {
    private int id;
    private String name;
    private int idcity;
    

    // Constructor, getters, and setters
    public Airport(int id, String name, Integer idcity) {
        this.id = id;
        this.name = name;
        this.idcity = idcity;
        
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

    public int getCity() {
        return idcity;
    }

    public void setCity(int city) {
        this.idcity = city;
    }

    @Override
    public String toString() {
        return " id: " + id + " | name: " + name;
    }

    public long getidCity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getidCity'");
    }

    public long getIdCity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdCity'");
    }
}

