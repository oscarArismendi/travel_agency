package com.o2.travel_agency.revision.domain.entity;

import java.sql.Date;

public class RevisionWithEmployee {
    private Integer id;
    private Date revisionDate;
    private Integer idPlane;
    private String description;
    private Integer idEmployee; // This field represents the employee assigned to this revision

    public RevisionWithEmployee(Integer id, Date revisionDate, Integer idPlane, String description,
            Integer idEmployee) {
        this.id = id;
        this.revisionDate = revisionDate;
        this.idPlane = idPlane;
        this.description = description;
        this.idEmployee = idEmployee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Date revisionDate) {
        this.revisionDate = revisionDate;
    }

    public Integer getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(Integer idPlane) {
        this.idPlane = idPlane;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public String toString() {
        return " id: " + id + " | revision date: " + revisionDate + " | description: " + description +
                " | idEmployee: " + idEmployee;
    }
}
