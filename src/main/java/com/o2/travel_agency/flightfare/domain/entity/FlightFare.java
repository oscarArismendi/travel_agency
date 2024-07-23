package com.o2.travel_agency.flightfare.domain.entity;

public class FlightFare {
    private Integer id;
    private String description;
    private String details;
    private Double value;

    // Constructor, getters, and setters
    public FlightFare(Integer id, String description, String details, Double value) {
        this.id = id;
        this.description = description;
        this.details = details;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return " id: " + id + " | description:" + description;
    }
}
