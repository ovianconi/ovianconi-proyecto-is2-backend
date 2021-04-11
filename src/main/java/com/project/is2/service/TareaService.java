package com.project.is2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.is2.entity.Tarea;
import com.project.is2.repository.TareaRepository;

@Service
public class TareaService {

	private TareaRepository tareaRepository;

	public TareaService(TareaRepository tareaRepository) {
		this.tareaRepository = tareaRepository;
	}

	public List<Tarea> getAllTarea() {
		List<Tarea> tareas = tareaRepository.findAll();
		for (Tarea t : tareas) {
			if (t.getIdTareaPadre() > 0) {
				t.setTareaPadre(tareaRepository.findById(t.getIdTareaPadre()).orElse(new Tarea()));
			}
		}

		return tareaRepository.findAll();
	}

	public Tarea createTarea(Tarea tarea) {
		return tareaRepository.save(tarea);
	}

	public Tarea updateTarea(Tarea entity) {
		return tareaRepository.save(entity);
	}

	public void deleteTarea(Integer id) {
		tareaRepository.deleteById(id);
	}
}