package com.api.hexagonal.common.valueobject;


import com.api.hexagonal.common.exception.DomainInvalidRequestException;

import java.util.Objects;

/**
 * Value object abstracto que contiene la logica de negocio encargada de validar
 * si un valor es válido
 * @param <T>
 */
public abstract class BaseId<T> {

    private final T value;

    protected BaseId(T value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(T value) {
        if (Objects.isNull(value)) {
            throw new DomainInvalidRequestException("El valor no es válido");
        }
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseId<?> that = (BaseId<?>) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
