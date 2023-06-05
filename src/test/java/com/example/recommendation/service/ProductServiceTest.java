package com.example.recommendation.service;

import com.example.recommendation.domain.dto.request.ProductRequest;
import com.example.recommendation.domain.dto.response.CommonResponse;
import com.example.recommendation.domain.dto.response.ProductResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductServiceTest {

    @Autowired
    TestRestTemplate testRestTemplate;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("상품 조회")
    @Order(1)
    void getProduct(){
        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/products/1", HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        Object resultDto = objectMapper.convertValue(body, CommonResponse.class).getData();
        ProductResponse productResponse = objectMapper.convertValue(resultDto, ProductResponse.class);

        assert body != null;
        assertEquals("A브랜드 상의", productResponse.getName());
    }

    @Test
    @Order(2)
    @DisplayName("상품 수정")
    void changeProductAll(){
        ProductRequest request = new ProductRequest("TOP", "A브랜드 상의", 9999, 10,
                "A", 100,200, 1, "SALE");
        HttpEntity<ProductRequest> requestEntity = createHttpEntity(request);

        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/products", HttpMethod.PUT, requestEntity,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        Object resultDto = objectMapper.convertValue(body, CommonResponse.class).getData();
        ProductResponse productResponse = objectMapper.convertValue(resultDto, ProductResponse.class);

        assert body != null;
        assertEquals(9999L, productResponse.getPrice());
    }

    @Test
    @Order(3)
    @DisplayName("상품 삭제")
    void deleteProduct(){
        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/products/1", HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();

        assert body != null;
    }

    @Test
    @Order(4)
    @DisplayName("상품 등록 (삭제 이후 진행)")
    void setProduct(){
        ProductRequest request = new ProductRequest("TOP", "A브랜드 상의", 200, 10,
                "A", 0, 200, 1, "SALE");
        HttpEntity<ProductRequest> requestEntity = createHttpEntity(request);

        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/products", HttpMethod.POST, requestEntity,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        Object resultDto = objectMapper.convertValue(body, CommonResponse.class).getData();
        ProductResponse productResponse = objectMapper.convertValue(resultDto, ProductResponse.class);

        assert body != null;
        assertEquals("A브랜드 상의", productResponse.getName());
    }

    private <T> HttpEntity<T> createHttpEntity(T t){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(t, httpHeaders);
    }
}
