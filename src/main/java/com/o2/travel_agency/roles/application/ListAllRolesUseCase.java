package com.o2.travel_agency.roles.application;

import java.util.List;

import com.o2.travel_agency.roles.domain.entity.Roles;
import com.o2.travel_agency.roles.domain.service.RolesService;

public class ListAllRolesUseCase {
    private final RolesService rolesService;

    public ListAllRolesUseCase(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    public List<Roles> execute() {
        return rolesService.listAllRoles();
    }
}
