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
public class Category {

    @Id
    private String categoryCd;
    private String categoryName;
    private int priority;
    @CreatedDate
    private Instant createDate;
    @LastModifiedDate
    private Instant updateDate;
}
