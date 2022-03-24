package com.br.felipesa.workshopmongo.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.br.felipesa.workshopmongo.services.exeption.ObjetoNaoEncontradoException;

@ControllerAdvice
public class ExcecaoDeRecursoHandler {
	
	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<PadraoErro> objetoNaoEncontrado(ObjetoNaoEncontradoException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		PadraoErro err = new PadraoErro(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
//      .value()	- converte pra numero inteiro
		return ResponseEntity.status(status).body(err);
	}

}
