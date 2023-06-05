package com.example.recommendation.domain.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PriceProductResponse {

    private long productNo;
    private String categoryName;
    private String brandCd;
    private long price;
}
