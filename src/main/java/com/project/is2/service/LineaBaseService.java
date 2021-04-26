package com.project.is2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.is2.entity.LineaBase;
import com.project.is2.entity.Tarea;
import com.project.is2.repository.LineaBaseRepository;
import com.project.is2.repository.TareaRepository;

@Service
public class LineaBaseService {

    private LineaBaseRepository lineaBaseRepository;
    private TareaRepository tareaRepository;

    @Autowired
    public LineaBaseService(LineaBaseRepository lineaBaseRepository, TareaRepository tareaRepository) {
        this.lineaBaseRepository = lineaBaseRepository;
        this.tareaRepository = tareaRepository;
    }

    public List<LineaBase> getAllBaseLines() {
        return lineaBaseRepository.findAll();
    }

    public LineaBase createBaseLine(LineaBase baseLine) {
        String biggerCode = lineaBaseRepository.findTopByOrderByCodeDesc()
                                .map(bl -> bl.getCode())
                                .orElse("0");
        baseLine.setCode(Integer.valueOf(biggerCode) + 1 + "");
        LineaBase savedBL = lineaBaseRepository.save(baseLine);

        if (baseLine.getTareas() != null) {
            for (Tarea t : baseLine.getTareas()) {
                Tarea currentTask = tareaRepository.findById(t.getId()).orElse(new Tarea());
                currentTask.setLineaBase(savedBL);
                tareaRepository.save(currentTask);
            }
        }
        return savedBL;
    }
    
    public int countBaseLines() {
        return getAllBaseLines().size();
    }

}