package com.o2.travel_agency.revisionEmployee.domain.entity;

public class RevisionEmployee {
    Integer idRevision;
    Integer idEmployee;

    public RevisionEmployee(Integer idRevision, Integer idEmployee) {
        this.idRevision = idRevision;
        this.idEmployee = idEmployee;
    }

    public Integer getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(Integer idRevision) {
        this.idRevision = idRevision;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public String toString() {
        return " idRevision: " + idRevision + " | idEmployee:" + idEmployee;
    }

}
