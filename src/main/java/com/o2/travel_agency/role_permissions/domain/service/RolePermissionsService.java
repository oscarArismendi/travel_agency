package com.o2.travel_agency.role_permissions.domain.service;

import java.util.List;

import com.o2.travel_agency.role_permissions.domain.entity.RolePermissions;

public interface RolePermissionsService {
    List<RolePermissions> listAllRolePermissions();
}
