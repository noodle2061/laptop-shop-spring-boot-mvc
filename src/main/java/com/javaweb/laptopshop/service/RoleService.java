package com.javaweb.laptopshop.service;

import com.javaweb.laptopshop.domain.Role;

public interface RoleService {
    Role findByName(String roleName);
}
