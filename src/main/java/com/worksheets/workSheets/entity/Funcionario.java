package com.worksheets.workSheets.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcionarioID;
    @NotBlank(message = "O nome do funcionário é obrigatório")
    private String funcionarioNome;
    @NotBlank(message = "O cargo do funcionário é obrigatório")
    private String funcionarioCargo;
    @Min(value = 1, message = "A carga horária deve ser maior que zero")
    @Max(value = 60, message = "A carga horária não pode ser maior que 60 horas")
    private Integer cargaHorariaSemanal;
    private boolean ativo;

    public Long getFuncionarioID() {
        return funcionarioID;
    }

    public void setFuncionarioID(Long funcionarioID) {
        this.funcionarioID = funcionarioID;
    }

    public String getFuncionarioNome() {
        return funcionarioNome;
    }

    public void setFuncionarioNome(String funcionarioNome) {
        this.funcionarioNome = funcionarioNome;
    }

    public String getFuncionarioCargo() {
        return funcionarioCargo;
    }

    public void setFuncionarioCargo(String funcionarioCargo) {
        this.funcionarioCargo = funcionarioCargo;
    }

    public Integer getCargaHorariaSemanal() {
        return cargaHorariaSemanal;
    }

    public void setCargaHorariaSemanal(Integer cargaHorariaSemanal) {
        this.cargaHorariaSemanal = cargaHorariaSemanal;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
