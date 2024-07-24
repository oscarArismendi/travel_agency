package com.o2.travel_agency.role_permissions.application;

import java.util.List;

import com.o2.travel_agency.role_permissions.domain.entity.RolePermissions;
import com.o2.travel_agency.role_permissions.domain.service.RolePermissionsService;

public class ListAllRolePermissionsUseCase {
    private final RolePermissionsService rolePermissionsService;

    public ListAllRolePermissionsUseCase(RolePermissionsService rolePermissionsService) {
        this.rolePermissionsService = rolePermissionsService;
    }

    public List<RolePermissions> execute() {
        return rolePermissionsService.listAllRolePermissions();
    }
}
