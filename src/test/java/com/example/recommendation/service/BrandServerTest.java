package com.example.recommendation.service;

import com.example.recommendation.domain.dto.request.BrandRequest;
import com.example.recommendation.domain.dto.response.BrandResponse;
import com.example.recommendation.domain.dto.response.CommonResponse;
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
class BrandServerTest {

    @Autowired
    TestRestTemplate testRestTemplate;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    @Order(1)
    @DisplayName("브랜드 등록")
    void setBrand(){
        BrandRequest request = new BrandRequest("X", "X브랜드");
        HttpEntity<BrandRequest> requestEntity = createHttpEntity(request);

        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/brands", HttpMethod.POST, requestEntity,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        Object resultDto = objectMapper.convertValue(body, CommonResponse.class).getData();
        BrandResponse brandResponse = objectMapper.convertValue(resultDto, BrandResponse.class);

        assert body != null;
        assertEquals("X", brandResponse.getBrandCd());
    }

    @Test
    @Order(2)
    @DisplayName("브랜드 수정")
    void changeBrand(){
        BrandRequest request = new BrandRequest("X", "X브랜드 변경됨");
        HttpEntity<BrandRequest> requestEntity = createHttpEntity(request);

        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/brands", HttpMethod.PUT, requestEntity,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();
        Object resultDto = objectMapper.convertValue(body, CommonResponse.class).getData();
        BrandResponse brandResponse = objectMapper.convertValue(resultDto, BrandResponse.class);

        assert body != null;
        assertEquals("X브랜드 변경됨", brandResponse.getBrandName());
    }

    @Test
    @Order(3)
    @DisplayName("브랜드 삭제")
    void deleteBrand(){
        ResponseEntity<?> responseEntity =
                testRestTemplate.exchange("/brands/X", HttpMethod.DELETE, null,
                        new ParameterizedTypeReference<>() {});
        Object body =  responseEntity.getBody();

        assert body != null;
    }

    private <T> HttpEntity<T> createHttpEntity(T t){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(t, httpHeaders);
    }
}
