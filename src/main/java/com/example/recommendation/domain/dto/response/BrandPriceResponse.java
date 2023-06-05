package com.example.recommendation.domain.dto.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BrandPriceResponse {

    String brandCd;
    String brandName;
    long totalPrice;
}
