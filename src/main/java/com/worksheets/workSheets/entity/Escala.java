package com.worksheets.workSheets.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Escala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long escalaID;
    @NotNull(message = "O funcionário é obrigatório")
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    @NotNull(message = "O turno é obrigatório")
    @ManyToOne
    @JoinColumn(name = "turno_id")
    private Turno turno;
    @NotNull(message = "A data é obrigatória")
    private LocalDate data;

    public Long getEscalaID() {
        return escalaID;
    }

    public void setEscalaID(Long escalaID) {
        this.escalaID = escalaID;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
