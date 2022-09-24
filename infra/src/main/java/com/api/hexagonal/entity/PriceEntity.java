package com.api.hexagonal.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Representa la tabla a nivel base de datos
 *
 * @author Ezequiel Cristeche
 */
@Entity
@Table(name = "PRICES")
@Data
public class PriceEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID", nullable = false, unique = false, referencedColumnName = "ID")
    private BrandEntity brandId;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "PRICE_LIST", nullable = false)
    private Long priceList;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;
    @Column(name = "PRIORITY", nullable = false)
    private Long priority;

    @Column(name = "PRICE", precision = 13, scale = 2)
    private BigDecimal price;

    @Column(nullable = false, name = "CURRENCY", columnDefinition = "varchar(4)")
    private String currency;

    public PriceEntity() {
    }


    public PriceEntity(Long productId, Long brandId, Long priceList, LocalDateTime startDate, LocalDateTime endDate,
                       BigDecimal price) {
        this.productId = productId;
        this.brandId = new BrandEntity(brandId);
        this.priceList = priceList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public PriceEntity(Long id, BrandEntity brandId, LocalDateTime startDate, LocalDateTime endDate,
                       Long priceList, Long productId, Long priority, BigDecimal price, String currency) {
        this.id = id;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }


}
