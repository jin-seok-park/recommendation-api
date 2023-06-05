package com.example.recommendation.domain.repository;


import com.example.recommendation.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {

    Optional<Category> findByCategoryCd(String categoryCd);
    Optional<List<Category>> findAllByOrderByPriority();

}
