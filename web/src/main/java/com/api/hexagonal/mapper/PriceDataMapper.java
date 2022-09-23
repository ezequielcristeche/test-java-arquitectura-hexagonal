package com.api.hexagonal.mapper;

import com.api.hexagonal.domain.entity.Price;
import com.api.hexagonal.dto.PriceResponseDTO;
import org.springframework.stereotype.Component;

/**
 * Mapea el dominio {@link Price} a un Data Transfer Object
 */
@Component
public class PriceDataMapper {

    public PriceResponseDTO convertDomainToDto(Price price) {
        return PriceResponseDTO.builder()
                .productId(price.getProductId().longValue())
                .brandId(price.getBrandId().getValue())
                .priceList(price.getPriceList().longValue())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .price(price.getPrice()).build();
    }

}
