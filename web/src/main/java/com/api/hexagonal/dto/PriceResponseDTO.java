package com.api.hexagonal.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * Devuelve la información correspondiente a Price
 *
 * @author Ezequiel Cristeche
 */
@Getter
@Builder
@AllArgsConstructor
public class PriceResponseDTO {

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("brand_id")
    private Long brandId;

    @JsonProperty("price_list")
    private Long priceList;

    @JsonProperty("start_date")
    private LocalDateTime startDate;

    @JsonProperty("end_date")
    private LocalDateTime endDate;

    @JsonProperty("price")
    private BigDecimal price;

}
