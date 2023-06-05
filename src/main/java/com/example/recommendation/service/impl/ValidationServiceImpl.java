package com.example.recommendation.service.impl;

import com.example.recommendation.domain.dto.request.BrandRequest;
import com.example.recommendation.domain.dto.request.ProductRequest;
import com.example.recommendation.exception.ResponseCodeEnum;
import com.example.recommendation.exception.RecommendationException;
import com.example.recommendation.service.ValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class ValidationServiceImpl implements ValidationService {

    @Override
    public void validationBrand(BrandRequest brandRequest){
        if(!StringUtils.hasText(brandRequest.getBrandCd())){
            throw new RecommendationException(ResponseCodeEnum.REQUEST_BRAND_CD_NULL);
        }
        if(!StringUtils.hasText(brandRequest.getBrandName())){
            throw new RecommendationException(ResponseCodeEnum.REQUEST_BRAND_NAME_NULL);
        }
    }

    @Override
    public void validationProduct(ProductRequest productRequest) {
        if(!StringUtils.hasText(productRequest.getCategoryCd())){
            throw new RecommendationException(ResponseCodeEnum.REQUEST_PRODUCT_CATEGORY_CD_NULL);
        }
        if(0L == productRequest.getPrice()){
            throw new RecommendationException(ResponseCodeEnum.REQUEST_PRODUCT_COUNT_NULL);
        }
        if(!StringUtils.hasText(productRequest.getBrandCd())){
            throw new RecommendationException(ResponseCodeEnum.REQUEST_BRAND_CD_NULL);
        }
        if(!StringUtils.hasText(productRequest.getName())){
            throw new RecommendationException(ResponseCodeEnum.REQUEST_PRODUCT_NAME_NULL);
        }
        if(0L == productRequest.getRequestUserNo()){
            throw new RecommendationException(ResponseCodeEnum.REQUEST_PRODUCT_REQUESTER_NULL);
        }
    }

    @Override
    public void validationUpdateProduct(ProductRequest productRequest) {
        if(0L == productRequest.getProductNo()){
            throw new RecommendationException(ResponseCodeEnum.REQUEST_PRODUCT_NO_NULL);
        }
        if(!StringUtils.hasText(productRequest.getSaleStatus())){
            throw new RecommendationException(ResponseCodeEnum.REQUEST_SALE_STATUS_NULL);
        }
        if(0 == productRequest.getPriority()){
            throw new RecommendationException(ResponseCodeEnum.REQUEST_PRIORITY_NULL);
        }
    }

}
