package com.example.recommendation.domain.dto.response;

import com.example.recommendation.service.SaleStatusEnum;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ProductResponse {

    long productNo;
    String categoryCd;
    String name;
    long price;
    long count;
    SaleStatusEnum saleStatus;
    String brandCd;
    int requestUserNo;

}
