package com.project.is2.repository;


import com.project.is2.entity.RolePermit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermitRepository extends JpaRepository<RolePermit, Integer> {
    void deleteByRoleId(int roleId);
}
