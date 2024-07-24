package com.o2.travel_agency.tripcrew.domain.entity;

public class TripCrew {

    Integer idEmployees;
    Integer idConection;

    public TripCrew() {
    }

    public TripCrew(Integer idEmployees, Integer idConection) {
        this.idEmployees = idEmployees;
        this.idConection = idConection;
    }

    public Integer getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(Integer idEmployees) {
        this.idEmployees = idEmployees;
    }

    public Integer getIdConection() {
        return idConection;
    }

    public void setIdConection(Integer idConection) {
        this.idConection = idConection;
    }

    @Override
    public String toString() {
        return " idEmployees: " + idEmployees + " | idConection: " + idConection;
    }

}
