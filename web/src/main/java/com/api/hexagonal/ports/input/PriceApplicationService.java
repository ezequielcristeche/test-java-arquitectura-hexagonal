package com.api.hexagonal.ports.input;


import com.api.hexagonal.dto.PriceDTO;
import com.api.hexagonal.dto.PriceResponseDTO;

import javax.validation.Valid;

/**
 * Puerto de entrada que se comunica con la capa de dominio
 */
public interface PriceApplicationService {

    PriceResponseDTO getAppliedPriceByDate(@Valid PriceDTO priceDTO);

}
