package com.project.is2.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.is2.entity.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {

}
