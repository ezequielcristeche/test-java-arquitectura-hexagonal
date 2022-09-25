package com.api.hexagonal.domain.entity;

import com.api.hexagonal.domain.valueobject.BrandId;

/**
 * Modela las reglas de negocio del dominio Brand
 *
 * @author Ezequiel Cristeche
 */
public class Brand {

    private BrandId brandId;
    private String name;

    public Brand(BrandId brandId, String name) {
        this.brandId = brandId;
        this.name = name;
    }

    public BrandId getBrandId() {
        return brandId;
    }

    public String getName() {
        return name;
    }


}
