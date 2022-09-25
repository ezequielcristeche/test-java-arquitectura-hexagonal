package com.api.hexagonal.advice;

import com.api.hexagonal.advice.error.ApiError;
import com.api.hexagonal.advice.error.ApiFieldError;
import com.api.hexagonal.common.exception.DomainInvalidRequestException;
import com.api.hexagonal.common.exception.DomainNotFoundException;
import com.api.hexagonal.constants.MensajeHttpStatus;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;

/**
 * Maneja las excepciones de manera global
 *
 * @author Ezequiel Cristeche
 */
@ControllerAdvice
public class DomainAdvice {


    @ResponseBody
    @ExceptionHandler(DomainNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ApiError domainNotFoundException(DomainNotFoundException domainNotFoundException){
        return new ApiError(HttpStatus.NOT_FOUND, MensajeHttpStatus.NO_ENCONTRADO,
                Collections.singletonList(new ApiFieldError(null, domainNotFoundException.getMessage())));
    }

    @ResponseBody
    @ExceptionHandler(DomainInvalidRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError domainInvalidRequestException(DomainInvalidRequestException domainInvalidRequestException){
        return new ApiError(HttpStatus.BAD_REQUEST, MensajeHttpStatus.REQUEST_INCORRECTO,
                Collections.singletonList(new ApiFieldError(null, domainInvalidRequestException.getMessage())));
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiError methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        BindingResult result = methodArgumentNotValidException.getBindingResult();
        return new ApiError(HttpStatus.BAD_REQUEST, MensajeHttpStatus.REQUEST_INCORRECTO,
                Collections.singletonList(new ApiFieldError(result.getFieldError().getField(),
                        result.getFieldError().getDefaultMessage())));
    }
}

