package com.project.is2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.is2.entity.Proyecto;
import com.project.is2.entity.Tarea;
import com.project.is2.repository.ProyectoRepository;
import com.project.is2.repository.TareaRepository;

@Service
public class ProyectoService {

    private ProyectoRepository proyectoRepository;
    private TareaRepository tareaRepository;

    @Autowired
    public ProyectoService(ProyectoRepository proyectoRepository, TareaRepository tareaRepository) {
        this.proyectoRepository = proyectoRepository;
        this.tareaRepository = tareaRepository;
    }

    public List<Proyecto> getAllProyecto() {
        return proyectoRepository.findAll();
    }

    public Proyecto createProyecto(Proyecto newProyecto) {
        Proyecto savedProyecto = proyectoRepository.save(newProyecto);

        if (newProyecto.getTareas() != null && !newProyecto.getTareas().isEmpty()) {
            for (Tarea t : newProyecto.getTareas()) {
                t.setProyecto(savedProyecto);
            }
            tareaRepository.saveAll(newProyecto.getTareas());
        }

        return savedProyecto;
    }

    @Transactional
    public Proyecto updateProyecto(Proyecto proyecto) {
        Proyecto currentProject = proyectoRepository.findById(proyecto.getId()).orElse(null);
        if (currentProject == null)
            return null;

        return proyectoRepository.save(proyecto);
    }
    
    public int countProject() {
        return getAllProyecto().size();
    }

}