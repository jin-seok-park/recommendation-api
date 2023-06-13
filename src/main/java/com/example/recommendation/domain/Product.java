package com.example.recommendation.domain;

import com.example.recommendation.domain.dto.request.ProductRequest;
import com.example.recommendation.service.SaleStatusEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productNo;
    private String categoryCd;
    private String name;
    private long price;
    private long count;
    @Enumerated(EnumType.STRING)
    private SaleStatusEnum saleStatus;
    private String brandCd;
    private int priority;
    @CreatedDate
    private Instant createDate;
    private int createUserNo;
    @LastModifiedDate
    private Instant updateDate;
    private int updateUserNo;

    private static final int DEFAULT_PRIORITY = 100;

    public void updateProductInfo(ProductRequest productRequest){
        this.categoryCd = productRequest.getCategoryCd();
        this.name = productRequest.getName();
        this.price = productRequest.getPrice();
        this.count = productRequest.getCount();
        this.saleStatus = SaleStatusEnum.getSaleStatusEnum(productRequest.getSaleStatus());
        this.brandCd = productRequest.getBrandCd();
        this.priority = productRequest.getPriority();
        this.updateUserNo = productRequest.getRequestUserNo();
    }

}
