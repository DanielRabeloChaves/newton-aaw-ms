package com.newton.aaw.hr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) // Se essa exceção for acionada o sistema vai devolver NotFound(erro 404) para o usuario
public class NotFoundException extends RuntimeException{
	public NotFoundException(String msg) { // Construtor
		super(msg); //Uma exceção que vai representar a mensagem de objeto nao encontrado.
	}

}
