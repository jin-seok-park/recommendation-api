package com.example.recommendation.service;

import com.example.recommendation.domain.dto.response.CategoryPriceRangeResponse;
import com.example.recommendation.domain.dto.response.CommonResponse;
import com.example.recommendation.domain.dto.response.MinPriceBrandResponse;
import com.example.recommendation.domain.dto.response.TotalPriceProductResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RecommendationServiceTest {

    @Autowired
    TestRestTemplate testRestTemplate;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("상품 최저가 계산")
    @Order(1)
    void calculateTotalPrice(){
        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/products/category/calculate", HttpMethod.POST, null,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        assert body != null;
    }

    @Test
    @DisplayName("상품 최저가 계산")
    void getMinPriceProduct(){
        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/products/category/min-price", HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        Object resultDto = objectMapper.convertValue(body, CommonResponse.class).getData();
        TotalPriceProductResponse totalPriceProductResponse = objectMapper.convertValue(resultDto, TotalPriceProductResponse.class);
        assert body != null;
        assertEquals(34100L, totalPriceProductResponse.getTotalPrice());
    }


    @Test
    @DisplayName("상품 최저가 계산")
    void getMinPriceBrand(){
        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/products/category/min-price/total", HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        Object resultDto = objectMapper.convertValue(body, CommonResponse.class).getData();
        MinPriceBrandResponse minPriceBrandResponse = objectMapper.convertValue(resultDto, MinPriceBrandResponse.class);
        assert body != null;
        assertEquals("D", minPriceBrandResponse.getBrand());
    }


    @Test
    @DisplayName("상품 최저가 계산")
    void getCategoryPriceRange(){
        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/products/category/TOP/price-range", HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        Object resultDto = objectMapper.convertValue(body, CommonResponse.class).getData();
        CategoryPriceRangeResponse categoryPriceRangeResponse = objectMapper.convertValue(resultDto, CategoryPriceRangeResponse.class);
        assert body != null;
        assertEquals("상의", categoryPriceRangeResponse.getCategoryName());
    }

}
