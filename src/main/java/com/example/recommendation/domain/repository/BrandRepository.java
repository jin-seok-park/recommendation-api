package com.example.recommendation.domain.repository;

import com.example.recommendation.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, String> {

    Optional<Brand> findByBrandCd(String brandCd);
    Optional<Brand> findFirstByOrderByTotalPrice();

    int deleteByBrandCd(String brandCd);

}
