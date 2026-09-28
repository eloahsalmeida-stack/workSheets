package com.worksheets.workSheets.controller;

import com.worksheets.workSheets.entity.Escala;
import com.worksheets.workSheets.service.EscalaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EscalaController {
    @Autowired
    private EscalaService escalaService;

    @PostMapping
    public Escala salvar(@Valid @RequestBody Escala escala) {
        return this.escalaService.salvar(escala);
    }

    @GetMapping
    public List<Escala> listarEscalasAll() {
        return this.escalaService.listarEscalasAll();
    }

    @GetMapping("/{id}")
    public Escala findByID(@PathVariable Long id) {
        return this.escalaService.findEscalasByID(id);
    }

    @PutMapping("/{id}")
    public Escala atualizarEscala(@PathVariable Long id, @RequestBody Escala escala) {
        return this.escalaService.atualizarEscala(id, escala);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        this.escalaService.excluirEscala(id);
    }
}
