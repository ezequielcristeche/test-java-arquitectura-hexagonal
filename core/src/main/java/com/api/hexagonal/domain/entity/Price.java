package com.api.hexagonal.domain.entity;

import com.api.hexagonal.common.exception.DomainInvalidRequestException;
import com.api.hexagonal.common.validator.Attribute;
import com.api.hexagonal.common.validator.Identifier;
import com.api.hexagonal.domain.valueobject.BrandId;
import com.api.hexagonal.domain.valueobject.PriceId;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Modela las reglas de negocio del dominio Price
 *
 * @author Ezequiel Cristeche
 */
public class Price {

    private PriceId priceId;

    private BrandId brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Long priceList;

    private Long productId;

    private Long priority;

    private BigDecimal price;

    private String currency;


    public Price(PriceId priceId, BrandId brandId, LocalDateTime startDate, LocalDateTime endDate, Long priceList,
                 Long productId, Long priority, BigDecimal price, String currency) {
        this.priceId = priceId;
        this.brandId = brandId;
        this.startDate = validateDate(startDate);
        this.endDate = validateDate(endDate);
        this.priceList = priceList;
        this.productId = productId;
        this.priority = validatePriority(priority);
        this.price = price;
        this.currency = validateCurrency(currency);
    }

    public Price(Long productId, BrandId brandId, Long priceList, LocalDateTime startDate, LocalDateTime endDate,
                 BigDecimal price) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.startDate = validateDate(startDate);
        this.endDate = validateDate(endDate);
        this.price = price;
    }

    public Price (Long productId, Long brandId) {
        this.productId = productId;
        this.brandId = new BrandId(brandId);
    }

    private LocalDateTime validateDate(LocalDateTime date) {
        Attribute.isNullObject(date, "la fecha no puede ser nula/vacia");
        return date;
    }

    private Long validatePriceList(Long priceList) {
        Attribute.isNullObject(priceList, "el identificador del precio de lista no puede ser nula/vacia");
        if (!Identifier.isValidNumber(priceList)) {
            throw new DomainInvalidRequestException("Identificador de precio de lista no válido");
        }
        return priceList;
    }

    private Long validateProduct(Long productId) {
        Attribute.isNullObject(productId, "el identificador del producto no puede ser nulo/vacio");
        if (!Identifier.isValidNumber(productId)) {
            throw new DomainInvalidRequestException("Identificador de producto no válido");
        }
        return productId;
    }

    private Long validatePriority(Long priority) {
        Attribute.isNullObject(priority, "la prioridad no puede ser nula/vacia");
        if (!Identifier.isValidNumber(priority)) {
            throw new DomainInvalidRequestException("El numero de prioridad no es válido");
        }
        return priority;
    }

    private String validateCurrency(String currency) {
        Attribute.isBlankAttribute(currency, "la moneda no puede ser nula/vacia");
        if (!Identifier.isValidCode(currency)) {
            throw new DomainInvalidRequestException("El codigo de la monedad no es válido");
        }
        return currency;
    }

    public PriceId getPriceId() {
        return priceId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Long getPriceList() {
        return priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getPriority() {
        return priority;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public BrandId getBrandId() {
        return brandId;
    }
}
