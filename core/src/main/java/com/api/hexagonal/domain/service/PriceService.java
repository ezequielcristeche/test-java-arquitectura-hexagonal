package com.api.hexagonal.domain.service;

import java.time.LocalDateTime;

/**
 * Es el puerto de entrada que comunicará la aplicación con el exterior
 * @author Ezequiel Cristeche
 */
public interface PriceService {

    PriceData getPriceByDate(LocalDateTime applicationDate, Long productId, Long brandId);
}
