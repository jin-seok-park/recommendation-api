package com.example.recommendation.exception;

import lombok.Getter;

@Getter
public class RecommendationException extends RuntimeException{

    private final ResponseCodeEnum error;

    public RecommendationException(ResponseCodeEnum error){
        super(error.getMessage());
        this.error = error;
    }

}
