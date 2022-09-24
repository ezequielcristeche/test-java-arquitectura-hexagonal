package com.api.hexagonal.domain.service;

import com.api.hexagonal.common.exception.DomainNotFoundException;
import com.api.hexagonal.domain.entity.Brand;
import com.api.hexagonal.domain.entity.Price;
import com.api.hexagonal.domain.repository.BrandRepository;
import com.api.hexagonal.domain.repository.PriceRepository;
import com.api.hexagonal.domain.valueobject.BrandId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

class PriceServiceImplTest {

    @Mock
    private PriceRepository priceRepository;

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private PriceServiceImpl priceService;

    private Price price;

    private Brand brand;

    private final Long PRODUCT_ID = 35455L;

    private final long BRAND_ID = 1L;

    private final String START_DATE = "2020-06-14T10:00";


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        price = new Price(PRODUCT_ID, new BrandId(BRAND_ID), 1L,
                LocalDateTime.parse(START_DATE), LocalDateTime.parse("2020-12-31T23:59:59"),
                new BigDecimal("35.50"));
        brand = new Brand(new BrandId(1L), "ZARA");

    }

    @Test
    void getPriceByDate() {
        when(brandRepository.findById(new BrandId(BRAND_ID))).thenReturn(Optional.of(brand));
        when(priceRepository.getPriceByDates(LocalDateTime.parse(START_DATE),
                PRODUCT_ID, BRAND_ID)).thenReturn(Optional.of(new Price(PRODUCT_ID, new BrandId(BRAND_ID), 1L,
                LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"),
                new BigDecimal("35.50"))));
        assertNotNull(priceService.getPriceByDate(LocalDateTime.parse(START_DATE),
                PRODUCT_ID, 1L));
        assertEquals(35455L, price.getProductId().longValue());
    }

    @Test
    void throwsDomainNotFoundExceptionWhenDoesNotExistBrand() {
        DomainNotFoundException domainNotFoundException = assertThrows(DomainNotFoundException.class,
                () -> priceService.getPriceByDate(LocalDateTime.parse(START_DATE),PRODUCT_ID, 2L));
        assertEquals(domainNotFoundException.getMessage(), "No existe una marca con id: "+2L);
    }

    @Test
    void throwsDomainNotFoundExceptionWhenDoesNotExistPrice() {
        when(brandRepository.findById(new BrandId(BRAND_ID))).thenReturn(Optional.of(brand));
        DomainNotFoundException domainNotFoundException = assertThrows(DomainNotFoundException.class,
                () -> priceService.getPriceByDate(LocalDateTime.parse(START_DATE),PRODUCT_ID, BRAND_ID));
        assertEquals(domainNotFoundException.getMessage(), "No se encuentra el precio a aplicar " +
                "para la fecha: "+ START_DATE +", producto: "+PRODUCT_ID+", marca: " + BRAND_ID + "");
    }


}