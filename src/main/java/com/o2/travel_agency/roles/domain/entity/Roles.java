package com.o2.travel_agency.roles.domain.entity;

public class Roles {
    Integer id;
    String name_role;

    public Roles() {
    }

    public Roles(Integer id, String name_role) {
        this.id = id;
        this.name_role = name_role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_role() {
        return name_role;
    }

    public void setName_role(String name_role) {
        this.name_role = name_role;
    }

    @Override
    public String toString() {
        return "  id: " + id + " | role name:" + name_role;
    }

}
