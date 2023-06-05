package com.example.recommendation.domain.dto.request;

import lombok.Value;


@Value
public class ProductRequest {


    String categoryCd;
    private String name;
    private long price;
    private long count;
    private String brandCd;
    private int priority;
    private int requestUserNo;

    // 업데이트시 사용
    private long productNo;
    private String saleStatus;

}
