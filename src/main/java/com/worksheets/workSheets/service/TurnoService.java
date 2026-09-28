package com.worksheets.workSheets.service;

import com.worksheets.workSheets.entity.Turno;
import com.worksheets.workSheets.exception.TurnoNaoEncontradoException;
import com.worksheets.workSheets.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoRepository;

    public Turno salvar(Turno turno) {
        return this.turnoRepository.save(turno);
    }

    public List<Turno> listarTurnosAll() {
        return this.turnoRepository.findAll();
    }

    public Turno findTurnoByID(Long id) {
        return this.turnoRepository.findById(id).orElseThrow(() -> new TurnoNaoEncontradoException(id));
    }

    public void excluirTurno(Long id) {
        Turno turno = this.turnoRepository.findById(id).orElseThrow(() -> new TurnoNaoEncontradoException(id));
        this.turnoRepository.deleteById(turno.getTurnoID());
    }

    public Turno atualizarTurno(Long id, Turno turnoAtualizado) {
        Turno turno = this.turnoRepository.findById(id).orElseThrow(() -> new TurnoNaoEncontradoException(id));

        turno.setTurnoNome(turnoAtualizado.getTurnoNome());
        turno.setHorarioInicio(turnoAtualizado.getHorarioInicio());
        turno.setHorarioFim(turnoAtualizado.getHorarioFim());

        return this.turnoRepository.save(turno);
    }
}
