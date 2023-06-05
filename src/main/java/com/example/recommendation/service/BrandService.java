package com.example.recommendation.service;

import com.example.recommendation.domain.dto.request.BrandRequest;
import com.example.recommendation.domain.dto.response.DeleteResponse;
import com.example.recommendation.domain.dto.response.BrandResponse;

public interface BrandService {
    BrandResponse setBrand(BrandRequest brandRequest);

    DeleteResponse deleteBrand(String brandCd);

    BrandResponse changeBrand(BrandRequest brandRequest);

}
