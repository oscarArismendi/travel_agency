package com.o2.travel_agency.customer.domain.entity;

public class Customer {
    Integer id;
    String firstName;
    String lastName;
    Integer age;
    Integer nroIdc;
    Integer idDocument;

    public Customer() {
    }

    public Customer(Integer id, String firstName, String lastName, Integer age, Integer nroIdc, Integer idDocument) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nroIdc = nroIdc;
        this.idDocument = idDocument;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNroIdc() {
        return nroIdc;
    }

    public void setNroIdc(Integer nroIdc) {
        this.nroIdc = nroIdc;
    }

    public Integer getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Integer idDocument) {
        this.idDocument = idDocument;
    }

    @Override
    public String toString() {
        return " id: " + id + " | firstName: " + firstName + " | lastName: " + lastName + " | nroIdc: " + nroIdc;
    }

}
