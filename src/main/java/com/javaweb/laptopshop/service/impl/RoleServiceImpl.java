package com.javaweb.laptopshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.laptopshop.domain.Role;
import com.javaweb.laptopshop.repository.RoleRepository;
import com.javaweb.laptopshop.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
