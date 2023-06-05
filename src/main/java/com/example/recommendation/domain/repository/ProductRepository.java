package com.example.recommendation.domain.repository;

import com.example.recommendation.domain.Product;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<List<Product>> findByBrandCd(String brandCd);

    Optional<Product> findFirstByCategoryCdOrderByPriceAscPriorityAsc(String categoryCd);

    Optional<Product> findFirstByCategoryCdOrderByPriceDescPriorityAsc(String categoryCd);

    int deleteByProductNo(long productNo);

    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<Product> findByProductNo(long productNo);

    Optional<List<Product>> findByBrandCdAndCategoryCd(String brandCd, String categoryCd);
}
