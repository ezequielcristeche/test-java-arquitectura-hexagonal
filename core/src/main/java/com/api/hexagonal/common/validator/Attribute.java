package com.api.hexagonal.common.validator;

import java.util.Objects;

import com.api.hexagonal.common.exception.DomainInvalidRequestException;
import org.apache.commons.lang3.StringUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Clase utilitaria para los atributos de los dominios
 * 
 * @author Ezequiel Cristeche
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Attribute {

	/**
	 * Validación genérica de un objeto nulo con la excepción genérica definida para
	 * dominios
	 * 
	 * @param obj
	 * @param message
	 */
	public static void isNullObject(Object obj, String message) {
		if (Objects.isNull(obj)) {
			throw new DomainInvalidRequestException(message);
		}
	}

	/**
	 * Validación genérica de un atributo de tipo {@link String}
	 * 
	 * @param attribute
	 * @param message mensaje de la excepción cuando el atributo no
	 *                                es válido
	 */
	public static void isBlankAttribute(String attribute, String message) {
		if (StringUtils.isBlank(attribute)) {
			throw new DomainInvalidRequestException(message);
		}
	}


}