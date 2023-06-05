package com.example.recommendation.domain.dto.response;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class BrandResponse {

    String brandCd;
    String brandName;

}
