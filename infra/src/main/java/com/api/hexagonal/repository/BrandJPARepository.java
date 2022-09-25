package com.api.hexagonal.repository;

import com.api.hexagonal.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface de @{@link BrandEntity}
 */
@Repository
public interface BrandJPARepository extends JpaRepository<BrandEntity, Long> {

    Optional<BrandEntity> findById(Long id);

}
