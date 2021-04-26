package com.project.is2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.project.is2.entity.LineaBase;

@Repository
public interface LineaBaseRepository extends JpaRepository<LineaBase, Integer> {
    Optional<LineaBase> findTopByOrderByCodeDesc();
}
