package com.api.hexagonal.common.exception;


/**
 * Exception generico para los datos no validos enviados en los servicios
 *
 * @author Ezequiel Cristeche
 */

public class DomainInvalidRequestException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6417559778965033514L;

	public DomainInvalidRequestException(String mensaje) {
        super(mensaje);
    }
}
