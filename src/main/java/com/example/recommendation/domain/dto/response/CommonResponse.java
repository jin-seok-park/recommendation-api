package com.example.recommendation.domain.dto.response;

import com.example.recommendation.exception.RecommendationException;
import com.example.recommendation.exception.ResponseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class CommonResponse {

    private Object data;
    private String message;
    private String code;


    @Builder(builderClassName = "normal", builderMethodName = "normal")
    private CommonResponse (Object data) {
        this.code = ResponseCodeEnum.NORMAL.getCode();
        this.message = ResponseCodeEnum.NORMAL.getMessage();
        this.data = data;
    }

    @Builder(builderClassName = "error", builderMethodName = "error")
    public CommonResponse (RecommendationException e){
        this.code = e.getError().getCode();
        this.message = e.getError().getMessage();
    }

}

