package com.api.hexagonal.common.validator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

/**
 * Validador generico de identificadores
 * 
 * @author Ezequiel Cristeche
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Identifier {

	/**
	 * Validación para un identificador de tipo {@link Long}
	 * 
	 * @param identifier identificador
	 * @return verdadero si es correcto o falso en caso contrario
	 */
	public static boolean isValidNumber(Long identifier) {
		return Pattern.compile("^[0-9]{0,20}$").matcher(identifier.toString()).find();
	}

	/**
	 * Validación para un identificador de tipo {@link String}
	 * 
	 * @param code identificador de tipo código
	 * @return verdadero si es correcto o falso en caso contrario
	 */
	public static boolean isValidCode(String code) {
		return Pattern.compile("^[A-Z][A-Za-z_]{0,9}$").matcher(code).find();
	}
}