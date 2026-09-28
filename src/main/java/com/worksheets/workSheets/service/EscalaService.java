package com.worksheets.workSheets.service;

import com.worksheets.workSheets.entity.Escala;
import com.worksheets.workSheets.entity.Funcionario;
import com.worksheets.workSheets.entity.Turno;
import com.worksheets.workSheets.exception.EscalaNaoEncontradaException;
import com.worksheets.workSheets.exception.FuncionarioNaoEncontradoException;
import com.worksheets.workSheets.exception.TurnoNaoEncontradoException;
import com.worksheets.workSheets.repository.EscalaRepository;
import com.worksheets.workSheets.repository.FuncionarioRepository;
import com.worksheets.workSheets.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscalaService {

    @Autowired
    private EscalaRepository escalaRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private TurnoRepository turnoRepository;

    public Escala salvar(Escala escala) {
        Long funcionarioID = escala.getFuncionario().getFuncionarioID();
        Long turnoID = escala.getTurno().getTurnoID();

        Funcionario funcionario = funcionarioRepository.findById(funcionarioID)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException(funcionarioID));

        Turno turno = turnoRepository.findById(turnoID)
                .orElseThrow(() -> new TurnoNaoEncontradoException(turnoID));

        escala.setFuncionario(funcionario);
        escala.setTurno(turno);

        return escalaRepository.save(escala);
    }

    public List<Escala> listarEscalasAll() {
        return this.escalaRepository.findAll();
    }

    public Escala findEscalasByID(Long id) {
        return this.escalaRepository.findById(id).orElseThrow(() -> new EscalaNaoEncontradaException(id));
    }

    public void excluirEscala(Long id) {
        Escala escala = this.escalaRepository.findById(id).orElseThrow(() -> new EscalaNaoEncontradaException(id));
        this.escalaRepository.deleteById(escala.getEscalaID());
    }

    public Escala atualizarEscala(Long id, Escala escalaAtualizada) {
        Escala escala = this.escalaRepository.findById(id).orElseThrow(() -> new EscalaNaoEncontradaException(id));

        escala.setFuncionario(escalaAtualizada.getFuncionario());
        escala.setTurno(escalaAtualizada.getTurno());
        escala.setData(escalaAtualizada.getData());

        return this.escalaRepository.save(escala);
    }
}
