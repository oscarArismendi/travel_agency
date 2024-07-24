package com.o2.travel_agency.role_permissions.domain.entity;

public class RolePermissions {
    Integer role_id;
    Integer permissions_id;

    public RolePermissions() {
    }

    public RolePermissions(Integer role_id, Integer permissions_id) {

        this.role_id = role_id;
        this.permissions_id = permissions_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getPermissions_id() {
        return permissions_id;
    }

    public void setPermissions_id(Integer permissions_id) {
        this.permissions_id = permissions_id;
    }

    @Override
    public String toString() {
        return " role id: " + role_id + " | permissions id: " + permissions_id;
    }

}
