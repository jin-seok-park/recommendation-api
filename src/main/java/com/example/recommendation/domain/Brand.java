package com.example.recommendation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
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
    }

    public void updateTotalPrice(long totalPrice){
        this.totalPrice = totalPrice;
    }

}
