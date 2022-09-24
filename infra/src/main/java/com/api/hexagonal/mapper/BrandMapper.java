package com.api.hexagonal.mapper;

import com.api.hexagonal.domain.entity.Brand;
import com.api.hexagonal.domain.valueobject.BrandId;
import com.api.hexagonal.entity.BrandEntity;
import org.springframework.stereotype.Component;

/**
 * Se encarga de realizar los mapeos necesarios
 */
@Component
public class BrandMapper implements AbstractMapper<BrandEntity, Brand> {


    @Override
    public Brand mapToDomain(BrandEntity entity) {
        return new Brand(new BrandId(entity.getId()), entity.getName());
    }

    @Override
    public BrandEntity mapToEntity(Brand domain) {
        return new BrandEntity(domain.getBrandId().getValue(), domain.getName());
    }
}
