package com.o2.travel_agency.city.domain.entity;

public class City {
    Integer id;
    String name;
    Integer idCountry;

    public City() {
    }

    public City(Integer id, String name, Integer idCountry) {
        this.id = id;
        this.name = name;
        this.idCountry = idCountry;
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

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    @Override
    public String toString() {
        return " id: " + id + " | name: " + name;
    }

}
