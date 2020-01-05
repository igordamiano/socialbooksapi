package com.igor.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.igor.socialbooks.domain.DetalhesErro;
import com.igor.socialbooks.services.exceptions.AutorExistenteException;
import com.igor.socialbooks.services.exceptions.AutorNaoEncontradoException;
import com.igor.socialbooks.services.exceptions.LivroNaoEncontradoException;

// Listener - Fica escutando e capturando exceções

@ControllerAdvice // -> Intercepta exceções do nosso código
public class ResourceExceptionHandler {

	// Registrar Handlers de exceções

	// Qualquer tipo lançado a exceção LivroNaoEncontradoException no codigo, retorna para o cliente um notfound
	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleLivroNaoEncontradoException(LivroNaoEncontradoException e,
			HttpServletRequest request) {
		
		DetalhesErro detalhesErro = new DetalhesErro();
		detalhesErro.setStatus(404l);
		detalhesErro.setTitulo("O livro não pôde ser encontrado.");
		detalhesErro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404"); // uma página detalhando os erros
		detalhesErro.setTimestamp(System.currentTimeMillis());

	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalhesErro);
	
	}
	
	@ExceptionHandler(AutorExistenteException.class)
	public ResponseEntity<DetalhesErro> handleAutorExistenteException(AutorExistenteException e,
			HttpServletRequest request) {
		
		DetalhesErro detalhesErro = new DetalhesErro();
		detalhesErro.setStatus(409l);
		detalhesErro.setTitulo("Autor já existente.");
		detalhesErro.setMensagemDesenvolvedor("http://erros.socialbooks.com/409"); // uma página detalhando os erros
		detalhesErro.setTimestamp(System.currentTimeMillis());

	return ResponseEntity.status(HttpStatus.CONFLICT).body(detalhesErro);
	
	}

	@ExceptionHandler(AutorNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleAutorNaoEncontradoException(AutorNaoEncontradoException e,
			HttpServletRequest request) {
		
		DetalhesErro detalhesErro = new DetalhesErro();
		detalhesErro.setStatus(404l);
		detalhesErro.setTitulo("Autor não encontrado.");
		detalhesErro.setMensagemDesenvolvedor("http://erros.socialbooks.com/404"); // uma página detalhando os erros
		detalhesErro.setTimestamp(System.currentTimeMillis());

	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalhesErro);
	
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<DetalhesErro> handleConstraintViolationException(ConstraintViolationException e,
			HttpServletRequest request) {
		
		DetalhesErro detalhesErro = new DetalhesErro();
		detalhesErro.setStatus(400l);
		detalhesErro.setTitulo("Requisição inválida.");
		detalhesErro.setMensagemDesenvolvedor("http://erros.socialbooks.com/400"); // uma página detalhando os erros
		detalhesErro.setTimestamp(System.currentTimeMillis());

	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(detalhesErro);
	
	}

	
}
