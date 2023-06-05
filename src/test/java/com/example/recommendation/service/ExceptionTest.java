package com.example.recommendation.service;

import com.example.recommendation.domain.dto.request.BrandRequest;
import com.example.recommendation.domain.dto.request.ProductRequest;
import com.example.recommendation.domain.dto.response.CommonResponse;
import com.example.recommendation.exception.ResponseCodeEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExceptionTest {

    @Autowired
    TestRestTemplate testRestTemplate;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("없는 상품 조회")
    void NOT_FOUND_EXCEPTION(){
        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/products/10000", HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        CommonResponse commonResponse = objectMapper.convertValue(body, CommonResponse.class);

        assert body != null;
        assertEquals(ResponseCodeEnum.NOT_FOUND_PRODUCT.getCode(), commonResponse.getCode());
    }

    @Test
    @DisplayName("없는 브랜드 수정")
    void NOT_FOUND_BRAND(){
        BrandRequest request = new BrandRequest("X", "X브랜드 변경됨");
        HttpEntity<BrandRequest> requestEntity = createHttpEntity(request);

        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/brands", HttpMethod.PUT, requestEntity,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        CommonResponse commonResponse = objectMapper.convertValue(body, CommonResponse.class);

        assert body != null;
        assertEquals(ResponseCodeEnum.NOT_FOUND_BRAND.getCode(), commonResponse.getCode());
    }

    @Test
    @DisplayName("존재하는 상품 등록 불가 - 브랜드/카테고리당 1개의 상품만 등록 가능")
    void existProduct(){
        ProductRequest request = new ProductRequest("TOP", "A브랜드 상의", 200, 10,
                "A", 0,200, 1, "SALE");
        HttpEntity<ProductRequest> requestEntity = createHttpEntity(request);

        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/products", HttpMethod.POST, requestEntity,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        CommonResponse commonResponse = objectMapper.convertValue(body, CommonResponse.class);

        assert body != null;
        assertEquals(ResponseCodeEnum.DUPLICATION_FAIL.getCode(), commonResponse.getCode());
    }

    @Test
    @DisplayName("상품이 존재하는 브랜드 삭제 불가")
    void deleteBrand4existProduct(){
        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/brands/A", HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        CommonResponse commonResponse = objectMapper.convertValue(body, CommonResponse.class);

        assert body != null;
        assertEquals(ResponseCodeEnum.EXIST_BRAND_PRODUCT.getCode(), commonResponse.getCode());
    }

    @Test
    @DisplayName("카테고리 정보가 없는 상품 등록 실패")
    void notFoundCategory(){
        ProductRequest request = new ProductRequest("JEWELRY", "A브랜드 보석", 200, 10,
                "A", 0, 200, 1, "SALE");
        HttpEntity<ProductRequest> requestEntity = createHttpEntity(request);

        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/products", HttpMethod.POST, requestEntity,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        CommonResponse commonResponse = objectMapper.convertValue(body, CommonResponse.class);

        assert body != null;
        assertEquals(ResponseCodeEnum.NOT_FOUND_CATEGORY.getCode(), commonResponse.getCode());
    }

    @Test
    @DisplayName("브랜드코드가 없을 경우 등록 실패")
    void requestBrandCdNull(){
        BrandRequest request = new BrandRequest(null, "X브랜드");
        HttpEntity<BrandRequest> requestEntity = createHttpEntity(request);

        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/brands", HttpMethod.POST, requestEntity,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        CommonResponse commonResponse = objectMapper.convertValue(body, CommonResponse.class);

        assert body != null;
        assertEquals(ResponseCodeEnum.REQUEST_BRAND_CD_NULL.getCode(), commonResponse.getCode());
    }

    @Test
    @DisplayName("상품이름이 없을 경우 등록 실패")
    void requestProductNameNull(){
        ProductRequest request = new ProductRequest("TOP", null, 200, 10,
                "A", 0, 200, 1, "SALE");
        HttpEntity<ProductRequest> requestEntity = createHttpEntity(request);

        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/products", HttpMethod.POST, requestEntity,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        CommonResponse commonResponse = objectMapper.convertValue(body, CommonResponse.class);

        assert body != null;
        assertEquals(ResponseCodeEnum.REQUEST_PRODUCT_NAME_NULL.getCode(), commonResponse.getCode());
    }

    @Test
    @DisplayName("상품번호가 없을 경우 수정 실패")
    void requestProductNoNull(){
        ProductRequest request = new ProductRequest("TOP", "A브랜드 상의", 9999, 10,
                "A", 0, 200, 0L, "SALE");
        HttpEntity<ProductRequest> requestEntity = createHttpEntity(request);

        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/products", HttpMethod.PUT, requestEntity,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        CommonResponse commonResponse = objectMapper.convertValue(body, CommonResponse.class);

        assert body != null;
        assertEquals(ResponseCodeEnum.REQUEST_PRODUCT_NO_NULL.getCode(), commonResponse.getCode());
    }

    private <T> HttpEntity<T> createHttpEntity(T t){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(t, httpHeaders);
    }

}
