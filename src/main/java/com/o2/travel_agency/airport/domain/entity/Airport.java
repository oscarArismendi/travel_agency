package com.o2.travel_agency.airport.domain.entity;

public class Airport {
    private Integer id;
    private String name;
    private Integer idcity;
    

    // Constructor, getters, and setters
    public Airport(Integer id, String name, Integer idcity) {
        this.id = id;
        this.name = name;
        this.idcity = idcity;
        
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Integer getIdCity() {
        return idcity;
    }


    public void setIdcity(Integer idcity) {
        this.idcity = idcity;
    }


    @Override
    public String toString() {
        return " id: " + id + " | name: " + name;
    }


}

