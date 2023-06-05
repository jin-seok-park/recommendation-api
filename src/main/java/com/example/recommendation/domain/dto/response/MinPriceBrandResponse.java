package com.example.recommendation.domain.dto.response;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class MinPriceBrandResponse {

    String brand;
    List<PriceProductResponse> categoryList;
    long totalPrice;

}
