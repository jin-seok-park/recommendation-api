package com.example.recommendation.domain.dto.response;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class TotalPriceProductResponse {

    long totalPrice;
    List<PriceProductResponse> productList;
}
