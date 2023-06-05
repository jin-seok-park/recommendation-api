package com.example.recommendation.service;

import com.example.recommendation.domain.dto.request.BrandRequest;
import com.example.recommendation.domain.dto.request.ProductRequest;

public interface ValidationService {

    void validationBrand(BrandRequest brandRequest);

    void validationProduct(ProductRequest productRequest);

    void validationUpdateProduct(ProductRequest productRequest);
}
