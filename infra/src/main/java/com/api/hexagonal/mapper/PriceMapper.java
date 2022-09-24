package com.api.hexagonal.mapper;

import com.api.hexagonal.domain.entity.Price;
import com.api.hexagonal.domain.valueobject.BrandId;
import com.api.hexagonal.entity.PriceEntity;
import com.api.hexagonal.repository.BrandJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Se encarga de realizar los mapeos necesarios
 */
@Component
public class PriceMapper implements AbstractMapper<PriceEntity, Price> {

    @Autowired
    private BrandMapper brandMapper;

    @Autowired
    private BrandJPARepository brandJPARepository;

    @Override
    public Price mapToDomain(PriceEntity entity) {
        return new Price(entity.getProductId(), new BrandId(entity.getBrandId().getId()), entity.getPriceList(),
                entity.getStartDate(), entity.getEndDate(), entity.getPrice());
    }

    @Override
    public PriceEntity mapToEntity(Price domain) {
        return new PriceEntity(domain.getProductId(), domain.getBrandId().getValue(), domain.getPriceList(),
                domain.getStartDate(), domain.getEndDate(), domain.getPrice());
    }

    public Price mapToDomain(PriceQuery priceQuery) {
        return new Price(priceQuery.getProductId().longValue(), new BrandId(priceQuery.getBrandId().longValue()),
                priceQuery.getPriceList().longValue(), priceQuery.getStartDate(),
                priceQuery.getEndDate(), priceQuery.getPrice());
    }
}
