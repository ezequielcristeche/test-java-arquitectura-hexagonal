package com.api.hexagonal.domain.service;

import com.api.hexagonal.domain.entity.Brand;

/**
 * Es el puerto de entrada que comunicará la aplicación con el exterior
 *
 * @author Ezequiel Cristeche
 */
public interface BrandService {

    Brand findById(Long id);
}
