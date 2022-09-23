package com.api.hexagonal.domain.repository;

import com.api.hexagonal.domain.entity.Brand;
import com.api.hexagonal.domain.entity.Price;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Puerto de salida que se comunica con las base de datos para obtener el @{@link Price}
 *
 * @author Ezequiel Cristeche
 */
public interface PriceRepository {

    /**
     * Busca un precio segùn los parametros indicados
     * @param applicationDate
     * @param productId identificador del producto
     * @param brandId identificador de @{@link Brand}
     * @return @{@link Price}
     */
    Optional<Price> getPriceByDates(LocalDateTime applicationDate, Long productId, Long brandId);

}
