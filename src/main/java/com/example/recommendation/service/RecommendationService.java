package com.example.recommendation.service;

import com.example.recommendation.domain.dto.response.BrandPriceResponse;
import com.example.recommendation.domain.dto.response.CategoryPriceRangeResponse;
import com.example.recommendation.domain.dto.response.MinPriceBrandResponse;
import com.example.recommendation.domain.dto.response.TotalPriceProductResponse;

import java.util.List;


public interface RecommendationService {

    TotalPriceProductResponse getMinPriceProduct();

    MinPriceBrandResponse getMinPriceBrand();

    CategoryPriceRangeResponse getCategoryPriceRange(String categoryCd);

    List<BrandPriceResponse> calculateTotalPrice();

    void calculateTotalPrice4Init();
}
