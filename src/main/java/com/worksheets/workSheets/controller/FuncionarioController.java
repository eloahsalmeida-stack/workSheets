package com.worksheets.workSheets.controller;

import com.worksheets.workSheets.entity.Funcionario;
import com.worksheets.workSheets.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public Funcionario salvar(@Valid @RequestBody Funcionario funcionario) {
        return this.funcionarioService.salvar(funcionario);
    }

    @GetMapping
    public List<Funcionario> listarFuncionariosAll() {
        return this.funcionarioService.listarFuncionariosAll();
    }

    @GetMapping("/{id}")
    public Funcionario findByID(@PathVariable Long id) {
        return this.funcionarioService.findFuncionarioByID(id);
    }

    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return this.funcionarioService.atualizarFuncionario(id, funcionario);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        this.funcionarioService.excluir(id);
    }

}
