package com.o2.travel_agency.plane.domain.entity;

import java.sql.Date;

public class Plane {
    private Integer id;
    private String plates;
    private Integer capacity;
    private Date fabricationDate;
    private Integer idAirline;
    private Integer idStatus;
    private Integer idModel;

    public Plane() {
    }

    public Plane(Integer id, String plates, Integer capacity, Date fabricationDate, Integer idAirline, Integer idStatus, Integer idModel) {
        this.id = id;
        this.plates = plates;
        this.capacity = capacity;
        this.fabricationDate = fabricationDate;
        this.idAirline = idAirline;
        this.idStatus = idStatus;
        this.idModel = idModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Date getFabricationDate() {
        return fabricationDate;
    }

    public void setFabricationDate(Date fabricationDate) {
        this.fabricationDate = fabricationDate;
    }

    public Integer getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(Integer idAirline) {
        this.idAirline = idAirline;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public Integer getIdModel() {
        return idModel;
    }

    public void setIdModel(Integer idModel) {
        this.idModel = idModel;
    }

}
