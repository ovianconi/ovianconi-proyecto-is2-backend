package com.project.is2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.is2.entity.Proyecto;
import com.project.is2.entity.Tarea;
import com.project.is2.repository.ProyectoRepository;
import com.project.is2.repository.TareaRepository;

@Service
public class TareaService {

	private TareaRepository tareaRepository;
	private ProyectoRepository proyectoRepository;

	@Autowired
	public TareaService(TareaRepository tareaRepository, ProyectoRepository proyectoRepository) {
		this.tareaRepository = tareaRepository;
		this.proyectoRepository = proyectoRepository;
	}

	public List<Tarea> getAllTarea() {
		return tareaRepository.findAll();
	}

	public Tarea createTarea(Tarea tarea) {

		Proyecto proyecto = proyectoRepository.findById(tarea.getProyecto().getId()).orElse(null);
		if (null == proyecto) {
			proyecto = new Proyecto();
		}
		proyecto.setNombre(tarea.getProyecto().getNombre());
		tarea.setProyecto(proyecto);
		return tareaRepository.save(tarea);
	}

	public Tarea updateTarea(Tarea entity) {

		return tareaRepository.save(entity);
	}

	public void deleteTarea(Integer id) {

		tareaRepository.deleteById(id);
	}
}