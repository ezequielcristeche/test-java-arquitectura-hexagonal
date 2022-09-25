package com.api.hexagonal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

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

    @NotNull(message = "el campo application_date no puede ser nulo")
    @JsonProperty("application_date")
    private LocalDateTime applicationDate;

    @NotNull(message = "el campo product_id no puede ser nulo")
    @JsonProperty("product_id")
    private Long productId;

    @NotNull(message = "el campo brand_id no puede ser nulo")
    @JsonProperty("brand_id")
    private Long brandId;

}
