package com.example.recommendation.controller;

import com.example.recommendation.domain.dto.response.*;
import com.example.recommendation.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/products/category")
public class RecommendationController {

    private final RecommendationService recommendationService;


    /**
     * 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API
     * @return
     */
    @GetMapping("/min-price")
    public ResponseEntity<CommonResponse> getMinPriceProduct() {
        log.info("== getMinPriceProduct ==");
        TotalPriceProductResponse totalPriceProductResponse = recommendationService.getMinPriceProduct();
        return ResponseEntity.ok(
                CommonResponse.normal()
                        .data(totalPriceProductResponse)
                        .build()
        );
    }

    /**
     * 총합이 가장 작은 브랜드 조회
     */
    @GetMapping("/min-price/total")
    public ResponseEntity<CommonResponse> getMinPriceBrand() {
        log.info("== getMinPriceBrand ==");
        MinPriceBrandResponse minPriceBrandResponse = recommendationService.getMinPriceBrand();
        return ResponseEntity.ok(
                CommonResponse.normal()
                        .data(minPriceBrandResponse)
                        .build()
        );
    }

    /**
     *  카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API 요청값
     */
    @GetMapping("/{categoryCd}/price-range")
    public ResponseEntity<CommonResponse> getCategoryPriceRange(@PathVariable String categoryCd){
        log.info("== getCategoryPriceRange ==");
        CategoryPriceRangeResponse categoryPriceRangeResponse = recommendationService.getCategoryPriceRange(categoryCd);
        return ResponseEntity.ok(
                CommonResponse.normal()
                        .data(categoryPriceRangeResponse)
                        .build()
        );
    }

    @PostMapping("/calculate")
    public ResponseEntity<CommonResponse> calculateTotalPrice() {
        log.info("== calculateTotalPrice ==");
        List<BrandPriceResponse> brandPriceResponseList = recommendationService.calculateTotalPrice();
        return ResponseEntity.ok(
                CommonResponse.normal()
                        .data(brandPriceResponseList)
                        .build()
        );
    }

}
