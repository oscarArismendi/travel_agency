package com.o2.travel_agency.revision.domain.entity;

import java.sql.Date;

public class Revision {
    private Integer id;
    private Date revisionDate;
    private Integer idPlane;
    private String description;

    public Revision() {
    }

    public Revision(Integer id, Date revisionDate, Integer idPlane, String description) {
        this.id = id;
        this.revisionDate = revisionDate;
        this.idPlane = idPlane;
        this.description = description;
    }

    

    public Revision(Date revisionDate, Integer idPlane, String description) {
        this.revisionDate = revisionDate;
        this.idPlane = idPlane;
        this.description = description;
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

    @Override
    public String toString() {
        return " id: " + id + " | revision date: " + revisionDate + " | description: " + description;
    }

}
