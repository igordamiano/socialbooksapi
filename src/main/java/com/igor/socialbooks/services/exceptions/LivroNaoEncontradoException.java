package com.igor.socialbooks.services.exceptions;

public class LivroNaoEncontradoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3346286616018677924L;

	public LivroNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public LivroNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
