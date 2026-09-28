package com.worksheets.workSheets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;


import java.time.LocalTime;

@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long turnoID;
    @NotBlank(message = "O nome do turno é obrigatório,")
    private String turnoNome;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;


    public Long getTurnoID() {
        return turnoID;
    }

    public void setTurnoID(Long turnoID) {
        this.turnoID = turnoID;
    }

    public String getTurnoNome() {
        return turnoNome;
    }

    public void setTurnoNome(String turnoNome) {
        this.turnoNome = turnoNome;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }
}
