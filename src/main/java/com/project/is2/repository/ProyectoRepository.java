package com.project.is2.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.is2.entity.Proyecto;
import com.project.is2.entity.Tarea;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
	void updateById(int proyectoId);
	void saveAll(List<Tarea> tareas);
}
