package com.igor.socialbooks.services.exceptions;

public class AutorExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2188918951522621150L;

	public AutorExistenteException(String mensagem) {
		super(mensagem);
	}

	public AutorExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
