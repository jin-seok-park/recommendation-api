package com.example.recommendation.controller;

import com.example.recommendation.domain.dto.response.CommonResponse;
import com.example.recommendation.exception.RecommendationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(RecommendationException.class)
    public ResponseEntity<CommonResponse> recommendationBusinessException(RecommendationException e) {
        log.error("## recommendationBusinessException -> [{}][{}] ##", e.getError().getCode(), e.getError().getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CommonResponse.error().e(e).build());
    }

}
