package com.api.hexagonal.constants;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

/**
 * Mensajes genéricos para los {@link HttpStatus}
 *
 * @author Ezequiel Cristeche
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MensajeHttpStatus {
	
	  /**
     * {@link HttpStatus#INTERNAL_SERVER_ERROR}
     */
    public static final String ERROR_INTERNO = "Error interno del servidor";

    /**
     * {@link HttpStatus#UNAUTHORIZED}
     */
    public static final String NO_AUTORIZADO = "No autorizado";

    /**
     * {@link HttpStatus#BAD_REQUEST}
     */
    public static final String REQUEST_INCORRECTO = "El request no es correcto";

    /**
     * {@link HttpStatus#CONFLICT}
     */
    public static final String CONFLICT = "Conflicto";

    /**
     * {@link HttpStatus#NOT_FOUND}
     */
    public static final String NO_ENCONTRADO = "No Encontrado";


}
