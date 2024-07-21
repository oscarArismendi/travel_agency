package com.o2.travel_agency.employee.domain.entity;

import java.sql.Date;

public class Employee {
    Integer id;
    String name;
    Date ingressDate;
    Integer idRol;
    Integer idUserRole;
    Integer idAirline;
    Integer idAirport;
    String email;
    String password;
    public Employee() {
    }
    public Employee(Integer id, String name, Date ingressDate, Integer idRol, Integer idUserRole, Integer idAirline,
            Integer idAirport, String email, String password) {
        this.id = id;
        this.name = name;
        this.ingressDate = ingressDate;
        this.idRol = idRol;
        this.idUserRole = idUserRole;
        this.idAirline = idAirline;
        this.idAirport = idAirport;
        this.email = email;
        this.password = password;
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
    public Date getIngressDate() {
        return ingressDate;
    }
    public void setIngressDate(Date ingressDate) {
        this.ingressDate = ingressDate;
    }
    public Integer getIdRol() {
        return idRol;
    }
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
    public Integer getIdUserRole() {
        return idUserRole;
    }
    public void setIdUserRole(Integer idUserRole) {
        this.idUserRole = idUserRole;
    }
    public Integer getIdAirline() {
        return idAirline;
    }
    public void setIdAirline(Integer idAirline) {
        this.idAirline = idAirline;
    }
    public Integer getIdAirport() {
        return idAirport;
    }
    public void setIdAirport(Integer idAirport) {
        this.idAirport = idAirport;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return " id: " + id + " | name: " + name ;
    }

}
