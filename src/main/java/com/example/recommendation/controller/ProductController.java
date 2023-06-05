package com.example.recommendation.controller;

import com.example.recommendation.domain.dto.request.ProductRequest;
import com.example.recommendation.domain.dto.response.CommonResponse;
import com.example.recommendation.domain.dto.response.DeleteResponse;
import com.example.recommendation.domain.dto.response.ProductResponse;
import com.example.recommendation.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    /**
     * 상품 조회
     */
    @GetMapping("/{productNo}")
    public ResponseEntity<CommonResponse> getProduct(@PathVariable long productNo) {
        log.info("== getProduct ==");
        ProductResponse productResponse = productService.getProduct(productNo);
        return ResponseEntity.ok(
                CommonResponse.normal()
                        .data(productResponse)
                        .build()
        );
    }

    /**
     * 상품 등록
     */
    @PostMapping
    public ResponseEntity<CommonResponse> setProduct(@RequestBody ProductRequest productRequest) {
        log.info("== setProduct ==");
        ProductResponse productResponse = productService.setProduct(productRequest);
        return ResponseEntity.ok(
                CommonResponse.normal()
                        .data(productResponse)
                        .build()
        );
    }

    /**
     * 상품 삭제
     */
    @DeleteMapping("/{productNo}")
    public ResponseEntity<CommonResponse> deleteProduct(@PathVariable long productNo) {
        log.info("== deleteProduct ==");
        DeleteResponse deleteResponse = productService.deleteProduct(productNo);
        return ResponseEntity.ok(
                CommonResponse.normal()
                        .data(deleteResponse)
                        .build()
        );
    }


    /**
     * 상품 수정 (전체 정보)
     */
    @PutMapping()
    public ResponseEntity<CommonResponse> changeProductAll(@RequestBody ProductRequest productRequest) {
        log.info("== changeProductAll ==");
        ProductResponse productResponse = productService.changeProduct(productRequest);
        return ResponseEntity.ok(
                CommonResponse.normal()
                        .data(productResponse)
                        .build()
        );
    }

}
