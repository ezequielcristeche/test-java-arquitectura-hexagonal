package com.api.hexagonal.domain.service;

import com.api.hexagonal.common.annotation.Service;
import com.api.hexagonal.common.exception.DomainNotFoundException;
import com.api.hexagonal.domain.entity.Brand;
import com.api.hexagonal.domain.entity.Price;
import com.api.hexagonal.domain.repository.BrandRepository;
import com.api.hexagonal.domain.repository.PriceRepository;
import com.api.hexagonal.domain.valueobject.BrandId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;


/**
 * Servicio encargado de impulsar la ejecucion para
 * obtener el precio aplicado segun las fechas
 */
@Service
public class PriceServiceImpl implements PriceService {

    private PriceRepository priceRepository;

    private BrandRepository brandRepository;

    private final static Logger LOGGER = LoggerFactory.getLogger(PriceServiceImpl.class);

    public PriceServiceImpl(PriceRepository priceRepository, BrandRepository brandRepository) {
        this.priceRepository = priceRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public PriceData getPriceByDate(LocalDateTime applicationDate, Long productId, Long brandId) {
        Brand brand = checkBrand(brandId);
        LOGGER.info("Se busca el precio a aplicar para la marca {}, producto {}, y fecha {}",
                brand.getBrandId().getValue(), productId, applicationDate);
        Price price = priceRepository.getPriceByDates(applicationDate, productId,
                brand.getBrandId().getValue()).orElseThrow(() -> {
            LOGGER.warn("No se encuentra un precio a aplicar para la fecha: {}, producto: {}, marca: {} ",
                    applicationDate, productId, brand.getBrandId().getValue());
            return new DomainNotFoundException(String.format("No se encuentra el precio a aplicar " +
                    "para la fecha: %s, producto: %s, marca: %s", applicationDate, productId, brandId));
        });
        LOGGER.info("Se encontro el precio a aplicar para la marca {}, producto {}, y fecha {}",
                brandId, productId, applicationDate);
        return new PriceData(price.getProductId(), price.getBrandId().getValue(),
                price.getPriceList(), price.getStartDate(),
                price.getEndDate(), price.getPrice());
    }

    /**
     * Verifica que exista la entity @{@link Brand}
     *
     * @param brandId identificador de la entity Brand
     * @return la entity Brand en caso de existir
     */
    private Brand checkBrand(Long brandId) {
        LOGGER.info("Se busca la marca con id: {}", brandId);
        return brandRepository.findById(new BrandId(brandId)).orElseThrow(() -> {
            LOGGER.warn("No existe una marca con id: {}", brandId);
            return new DomainNotFoundException("No existe una marca con id: " + brandId + "");
        });
    }


}
