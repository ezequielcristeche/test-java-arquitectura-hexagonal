package com.api.hexagonal.entity;

import javax.persistence.*;

/**
 * Representa la tabla a nivel base de datos
 * @author Ezequiel Cristeche
 */
@Entity
@Table(name = "BRANDS")
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, columnDefinition = "VARCHAR(20)")
    private String name;

    public BrandEntity() {
    }

    public BrandEntity(Long id) {
        this.id = id;
    }

    public BrandEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

}
