package com.api.hexagonal.domain.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Se encarga de devolver la información necesaria a la capa de aplicación
 */
public class PriceData {

    private Long productId;

    private Long brandId;

    private Long priceList;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private BigDecimal price;

    public PriceData() {

    }

    public PriceData(Long productId, Long brandId, Long priceList, LocalDateTime startDate,
                     LocalDateTime endDate, BigDecimal price) {
        this.productId = productId;
        this.brandId = brandId;
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Long getPriceList() {
        return priceList;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }


    public void setProductId(BigInteger productId) {
        this.productId = productId.longValue();
    }

    public void setBrandId(BigInteger brandId) {
        this.brandId = brandId.longValue();
    }

    public void setPriceList(BigInteger priceList) {
        this.priceList = priceList.longValue();
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate.toLocalDateTime();
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate.toLocalDateTime();
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
