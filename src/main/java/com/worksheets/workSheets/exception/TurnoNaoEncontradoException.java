package com.worksheets.workSheets.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TurnoNaoEncontradoException extends RuntimeException{

    public TurnoNaoEncontradoException(Long id) {
        super("Turno de id: " + id + "não encontrado.");
    }
}
