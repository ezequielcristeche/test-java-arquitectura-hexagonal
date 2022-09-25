package com.api.hexagonal.common.annotation;

import java.lang.annotation.*;

/**
 * Annotation personalizada para implementar en los casos de uso
 *
 * @author Ezequiel Cristeche
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Documented
public @interface Service {

}
