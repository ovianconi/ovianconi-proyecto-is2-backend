package com.project.is2.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "linea_base")
public class LineaBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "linea_base_id")
    private int id;
    
    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "lineaBase")
    private List<Tarea> tareas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}
}
