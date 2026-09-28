package com.worksheets.workSheets.controller;

import com.worksheets.workSheets.entity.Turno;
import com.worksheets.workSheets.service.TurnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;

    @PostMapping
    public Turno salvar(@Valid @RequestBody Turno turno){
        return this.turnoService.salvar(turno);
    }

    @GetMapping()
    public List<Turno> listarTurnosAll() {
        return this.turnoService.listarTurnosAll();
    }

    @DeleteMapping("/{id}")
    public void excluirTurno(@Valid @PathVariable Long id) {
        this.turnoService.excluirTurno(id);
    }

    @PutMapping("/{id}")
    public Turno atualizarTurno(@Valid @PathVariable Long id, @RequestBody Turno turno){
        return this.turnoService.atualizarTurno(id, turno);
    }

}
