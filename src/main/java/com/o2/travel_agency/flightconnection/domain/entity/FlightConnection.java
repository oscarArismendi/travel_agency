package com.o2.travel_agency.flightconnection.domain.entity;

public class FlightConnection {
    Integer id;
    String connectionNumber;
    Integer idTrip;
    Integer idPlane;
    Integer idAirport;

    public FlightConnection() {
    }

    public FlightConnection(Integer id, String connectionNumber, Integer idTrip, Integer idPlane, Integer idAirport) {
        this.id = id;
        this.connectionNumber = connectionNumber;
        this.idTrip = idTrip;
        this.idPlane = idPlane;
        this.idAirport = idAirport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConnectionNumber() {
        return connectionNumber;
    }

    public void setConnectionNumber(String connectionNumber) {
        this.connectionNumber = connectionNumber;
    }

    public Integer getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(Integer idTrip) {
        this.idTrip = idTrip;
    }

    public Integer getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(Integer idPlane) {
        this.idPlane = idPlane;
    }

    public Integer getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(Integer idAirport) {
        this.idAirport = idAirport;
    }

    @Override
    public String toString() {
        return " id:  " + id + "  | connectionNumber:  " + connectionNumber;
    }
}
