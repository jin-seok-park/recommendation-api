package com.example.recommendation.service.impl;

import com.example.recommendation.domain.Brand;
import com.example.recommendation.domain.dto.request.BrandRequest;
import com.example.recommendation.domain.dto.response.BrandResponse;
import com.example.recommendation.domain.dto.response.DeleteResponse;
import com.example.recommendation.exception.ResponseCodeEnum;
import com.example.recommendation.exception.RecommendationException;
import com.example.recommendation.service.BrandService;
import com.example.recommendation.service.ProductManager;
import com.example.recommendation.service.ValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final ProductManager productManager;
    private final ValidationService validationService;

    @Override
    public BrandResponse setBrand(BrandRequest brandRequest) {
        validationService.validationBrand(brandRequest);
        long brandCount = productManager.getBrandProductCount(brandRequest.getBrandCd());
        if(brandCount > 0){
            throw new RecommendationException(ResponseCodeEnum.DUPLICATION_BRAND_FAIL);
        }
        productManager.deleteTotalPriceCache();
        productManager.deleteMinPriceBrandCache();
        return createBrandResponse(productManager.setBrand(createBrand(brandRequest)));
    }

    /**
     * 해당 브랜드 상품이 존재할 경우 삭제 불가
     */
    @Override
    @Transactional
    public DeleteResponse deleteBrand(String brandCd) {
        long brandProductCount = productManager.getBrandProductCount(brandCd);
        if(brandProductCount > 0){
            throw new RecommendationException(ResponseCodeEnum.EXIST_BRAND_PRODUCT);
        }
        productManager.deleteTotalPriceCache();
        productManager.deleteMinPriceBrandCache();
        return createBrandDeleteResponse(productManager.deleteBrand(brandCd));
    }

    private DeleteResponse createBrandDeleteResponse(int deleteCount){
        return DeleteResponse.builder()
                .deleteCount(deleteCount)
                .build();
    }

    @Override
    @Transactional
    public BrandResponse changeBrand(BrandRequest brandRequest) {
        validationService.validationBrand(brandRequest);
        Brand brand = productManager.getBrand(brandRequest.getBrandCd());
        brand.updateBrandInfo(brandRequest.getBrandName());
        productManager.deleteTotalPriceCache();
        productManager.deleteMinPriceBrandCache();
        return createBrandResponse(brand);
    }



    private BrandResponse createBrandResponse(Brand brand){
        return BrandResponse.builder()
                .brandCd(brand.getBrandCd())
                .brandName(brand.getBrandName())
                .build();
    }

    private Brand createBrand(BrandRequest brandRequest){
        return Brand.builder()
                .brandCd(brandRequest.getBrandCd())
                .brandName(brandRequest.getBrandName())
                .totalPrice(Integer.MAX_VALUE)
                .build();
    }

}
