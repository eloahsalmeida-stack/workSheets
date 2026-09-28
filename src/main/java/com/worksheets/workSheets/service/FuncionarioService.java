package com.worksheets.workSheets.service;

import com.worksheets.workSheets.entity.Funcionario;
import com.worksheets.workSheets.exception.FuncionarioNaoEncontradoException;
import com.worksheets.workSheets.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario salvar(Funcionario funcionario) {
        return this.funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarFuncionariosAll() {
        return this.funcionarioRepository.findAll();
    }

    public Funcionario findFuncionarioByID(Long id) {
        return this.funcionarioRepository.findById(id).orElseThrow(() -> new FuncionarioNaoEncontradoException(id));
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionarioAtualizado) {
        Funcionario funcionario = this.funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException(id));

        funcionario.setFuncionarioNome(funcionarioAtualizado.getFuncionarioNome());
        funcionario.setFuncionarioCargo(funcionarioAtualizado.getFuncionarioCargo());
        funcionario.setCargaHorariaSemanal(funcionarioAtualizado.getCargaHorariaSemanal());
        funcionario.setAtivo(funcionarioAtualizado.isAtivo());

        return this.funcionarioRepository.save(funcionario);
    }

    public void excluir(Long id) {
        Funcionario funcionario = this.funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException(id));
        this.funcionarioRepository.deleteById(funcionario.getFuncionarioID());
    }
}
