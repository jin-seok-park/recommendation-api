package com.example.recommendation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Brand {

    @Id
    private String brandCd;
    private String brandName;
    private long totalPrice;
    @CreatedDate
    private Instant createDate;
    @LastModifiedDate
    private Instant updateDate;

    public void updateBrandInfo(String brandName){
        this.brandName = brandName;
        this.updateDate = Instant.now();
    }

    public void updateTotalPrice(long totalPrice){
        this.totalPrice = totalPrice;
        this.updateDate = Instant.now();
    }

}
