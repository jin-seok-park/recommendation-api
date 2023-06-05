package com.example.recommendation.service;

import com.example.recommendation.exception.ResponseCodeEnum;
import com.example.recommendation.exception.RecommendationException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum SaleStatusEnum {

    SALE("판매중"),
    SOLE_OUT("매진"),
    SALE_END("판매종료")
    ;

    private final String desc;

    public static SaleStatusEnum getSaleStatusEnum(String saleStatus) throws RecommendationException{
        return Arrays.stream(values())
                .filter(v -> v.name().equals(saleStatus.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new RecommendationException(ResponseCodeEnum.NOT_FOUND_SALE_STATUS));
    }
}
