package com.o2.travel_agency.plane.domain.entity;

import java.sql.Date;

import com.o2.travel_agency.airline.domain.entity.Airline;
import com.o2.travel_agency.model.domain.entity.Model;
import com.o2.travel_agency.status.domain.entity.Status;

public class Plane {
    private int id;
    private String plates;
    private Date fabrication_date;
    private Status status;
    private Model model;
    private Airline airline;

    public Plane() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public Date getFabrication_date() {
        return fabrication_date;
    }

    public void setFabrication_date(Date fabrication_date) {
        this.fabrication_date = fabrication_date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

}
