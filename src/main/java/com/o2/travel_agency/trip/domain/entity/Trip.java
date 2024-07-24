package com.o2.travel_agency.trip.domain.entity;

import java.util.Date;

public class Trip {
    private Integer id;
    private Date tripDate;
    private Double priceTrip;
    private Integer idOrigin;
    private Integer idDestination;

    public Trip() {
    }

    public Trip(Integer id, Date tripDate, Double priceTrip, Integer idOrigin, Integer idDestination) {
        this.id = id;
        this.tripDate = tripDate;
        this.priceTrip = priceTrip;
        this.idOrigin = idOrigin;
        this.idDestination = idDestination;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTripDate() {
        return tripDate;
    }

    public void setTripDate(Date tripDate) {
        this.tripDate = tripDate;
    }

    public Double getPriceTrip() {
        return priceTrip;
    }

    public void setPriceTrip(Double priceTrip) {
        this.priceTrip = priceTrip;
    }

    public Integer getIdOrigin() {
        return idOrigin;
    }

    public void setIdOrigin(Integer idOrigin) {
        this.idOrigin = idOrigin;
    }

    public Integer getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(Integer idDestination) {
        this.idDestination = idDestination;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", tripDate=" + tripDate +
                ", priceTrip=" + priceTrip +
                ", idOrigin=" + idOrigin +
                ", idDestination=" + idDestination +
                '}';
    }
}
