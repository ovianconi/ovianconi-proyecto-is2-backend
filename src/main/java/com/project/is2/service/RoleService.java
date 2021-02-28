package com.project.is2.service;

import java.util.List;

import com.project.is2.entity.Role;
import com.project.is2.repository.RolePermitRepository;
import com.project.is2.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {

    private RoleRepository roleRepository;
    private RolePermitRepository rolePermitRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository, RolePermitRepository rolePermitRepository) {
        this.roleRepository = roleRepository;
        this.rolePermitRepository = rolePermitRepository;
    }

    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }

    public Role createRole(Role newRole) {
        Role savedRole = roleRepository.save(newRole);

        newRole.getPermits().forEach(rp -> rp.setRole(savedRole));
        rolePermitRepository.saveAll(newRole.getPermits());

        return savedRole;
    }

    @Transactional
    public Role updateRole(Role role) {
        roleRepository.save(role);

        rolePermitRepository.deleteByRoleId(role.getId());
        role.getPermits().forEach(rp -> rp.setRole(role));
        rolePermitRepository.saveAll(role.getPermits());
        
        return role;
    }

}