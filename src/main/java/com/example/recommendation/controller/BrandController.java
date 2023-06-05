package com.example.recommendation.controller;

import com.example.recommendation.domain.dto.request.BrandRequest;
import com.example.recommendation.domain.dto.response.DeleteResponse;
import com.example.recommendation.domain.dto.response.BrandResponse;
import com.example.recommendation.domain.dto.response.CommonResponse;
import com.example.recommendation.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;

    /**
     * 브랜드 등록
     */
    @PostMapping
    public ResponseEntity<CommonResponse> setBrand(@RequestBody BrandRequest brandRequest) {
        log.info("== setBrand ==");
        BrandResponse brandResponse = brandService.setBrand(brandRequest);
        return ResponseEntity.ok(
                CommonResponse.normal()
                        .data(brandResponse)
                        .build()
        );
    }

    /**
     * 브랜드 삭제
     */
    @DeleteMapping("/{brandCd}")
    public ResponseEntity<CommonResponse> deleteBrand(@PathVariable String brandCd) {
        log.info("== deleteBrand ==");
        DeleteResponse deleteResponse = brandService.deleteBrand(brandCd);
        return ResponseEntity.ok(
                CommonResponse.normal()
                        .data(deleteResponse)
                        .build()
        );
    }

    /**
     * 브랜드 수정
     */
    @PutMapping()
    public ResponseEntity<CommonResponse> changeBrand(@RequestBody BrandRequest brandRequest) {
        log.info("== changeBrand ==");
        BrandResponse brandResponse = brandService.changeBrand(brandRequest);
        return ResponseEntity.ok(
                CommonResponse.normal()
                        .data(brandResponse)
                        .build()
        );
    }

}
