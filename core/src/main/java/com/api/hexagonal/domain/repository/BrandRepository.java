package com.api.hexagonal.domain.repository;

import com.api.hexagonal.domain.entity.Brand;
import com.api.hexagonal.domain.valueobject.BrandId;

import java.util.Optional;

/**
 * Puerto de salida que se comunica con las base de datos para obtener el @{@link Brand}
 *
 * @author Ezequiel Cristeche
 */
public interface BrandRepository {

    /**
     * Busca una Marca
     * @param brandId value object del dominio Brand
     * @return @{@link Brand}
     */
    Optional<Brand> findById(BrandId brandId);
}
