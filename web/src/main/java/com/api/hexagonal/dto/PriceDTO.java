package com.api.hexagonal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * datos de entrada para obtener el Price
 * @author Ezequiel Cristeche
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDTO {

    @NotNull(message = "the field application_date should not be empty")
    @JsonProperty("application_date")
    private LocalDateTime applicationDate;

    @NotNull(message = "the field product_id should not be empty")
    @JsonProperty("product_id")
    private Long productId;

    @NotNull(message = "the field brand_id should not be empty")
    @JsonProperty("brand_id")
    private Long brandId;

}
