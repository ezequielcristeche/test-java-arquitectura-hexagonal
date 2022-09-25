package com.api.hexagonal.adapter;

import com.api.hexagonal.common.exception.DomainNotFoundException;
import com.api.hexagonal.domain.entity.Brand;
import com.api.hexagonal.domain.repository.BrandRepository;
import com.api.hexagonal.domain.valueobject.BrandId;
import com.api.hexagonal.entity.BrandEntity;
import com.api.hexagonal.mapper.BrandMapper;
import com.api.hexagonal.repository.BrandJPARepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * Invoca al puerto de salida @{@link BrandRepository}
 */
@Service
public class BrandJPAImpl implements BrandRepository {

    private static Logger logger = LoggerFactory.getLogger(PriceAdapterImpl.class);

    @Autowired
    private BrandJPARepository brandJPARepository;

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public Optional<Brand> findById(BrandId brandId) {
        logger.info("Se busca la marca con id {}", brandId.getValue());
        BrandEntity brandEntity = brandJPARepository.findById(brandId.getValue()).orElseThrow(() ->
                new DomainNotFoundException(String.format("No existe una marca con id: %s", brandId.getValue())));
        logger.info("Se encontró correctamente la marca con id {}", brandId.getValue());
        return Optional.ofNullable(brandMapper.mapToDomain(brandEntity));
    }
}
