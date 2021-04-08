package com.project.is2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.is2.entity.Proyecto;
import com.project.is2.repository.ProyectoRepository;

@Service
public class ProyectoService {

	private ProyectoRepository proyectoRepository;

	@Autowired
	public ProyectoService(ProyectoRepository proyectoRepository) {
		this.proyectoRepository = proyectoRepository;
	}

    public List<Proyecto> getAllProyecto(){
        return proyectoRepository.findAll();
    }

    public Proyecto createProyecto(Proyecto newproyecto) {
        Proyecto savedProyecto = proyectoRepository.save(newproyecto);
        newproyecto.getTareas().forEach(t -> t.setProyecto(savedProyecto));
        proyectoRepository.saveAll(newproyecto.getTareas());
        return savedProyecto;
    }

    @Transactional
    public Proyecto updateProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
        proyectoRepository.updateById(proyecto.getId());
        proyecto.getTareas().forEach(t -> t.setProyecto(proyecto));
        proyectoRepository.saveAll(proyecto.getTareas());
        return proyecto;
    }

}