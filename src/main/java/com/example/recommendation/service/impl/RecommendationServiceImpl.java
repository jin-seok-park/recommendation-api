package com.example.recommendation.service.impl;

import com.example.recommendation.domain.Brand;
import com.example.recommendation.domain.Category;
import com.example.recommendation.domain.Product;
import com.example.recommendation.domain.dto.response.*;
import com.example.recommendation.exception.ResponseCodeEnum;
import com.example.recommendation.exception.RecommendationException;
import com.example.recommendation.service.ProductManager;
import com.example.recommendation.service.RecommendationService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final ProductManager productManager;

    @Override
    @Cacheable(value = "totalPriceCache")
    public TotalPriceProductResponse getMinPriceProduct() {
        List<Category> categoryList = productManager.getCategoryList();
        List<PriceProductResponse> priceProductResponseList = categoryList.stream()
                .map(v -> {
                    return  createProductDto(productManager.getProductMinPrice(v.getCategoryCd()), v.getCategoryName());
                })
                .collect(Collectors.toList());

        return TotalPriceProductResponse.builder()
                .totalPrice(getTotalPrice(priceProductResponseList))
                .productList(priceProductResponseList)
                .build();
    }

    private long getTotalPrice(List<PriceProductResponse> priceProductResponseList){
        return priceProductResponseList.stream().mapToLong(PriceProductResponse::getPrice).sum();
    }

    @Override
    @Cacheable(value = "minPriceBrandCache")
    public MinPriceBrandResponse getMinPriceBrand() {
        //브랜드별로 총합 구하기
        Brand brand = productManager.getMinPriceBrand();
        List<Product> productList = productManager.getBrandAllProduct(brand.getBrandCd());

        List<Category> categoryList = productManager.getCategoryList();

        List<PriceProductResponse> categoryProductDtoList = categoryList.stream()
                .map(v -> {
                    return matchCategory(v, productList);
                })
                .collect(Collectors.toList());
        return createMinPriceResponse(brand, categoryProductDtoList);
    }

    @Override
    @Cacheable(value = "categoryPriceRangeCache", key="#categoryCd")
    public CategoryPriceRangeResponse getCategoryPriceRange(String categoryCd) {
        return createCategoryPriceRangeResponse(categoryCd);
    }

    /**
     * 브랜드별 총 합 가격 계산
     */
    @Override
    @Transactional
    public List<BrandPriceResponse> calculateTotalPrice() {
        List<Brand> brandList = productManager.getAllBrand();
        for(Brand brand : brandList){
            long totalPrice = productManager.getBrandTotalPrice(brand.getBrandCd());
            brand.updateTotalPrice(totalPrice);
        }
        productManager.deleteTotalPriceCache();
        productManager.deleteMinPriceBrandCache();
        return brandList.stream()
                .map(v -> {
                    return createBrandPriceResponse(v);
                })
                .collect(Collectors.toList());
    }

    @Override
    @PostConstruct
    public void calculateTotalPrice4Init() {
        List<Brand> brandList = productManager.getAllBrand();
        for(Brand brand : brandList){
            long totalPrice = productManager.getBrandTotalPrice(brand.getBrandCd());
            brand.updateTotalPrice(totalPrice);
            productManager.setBrand(brand);
        }
    }

    private BrandPriceResponse createBrandPriceResponse(Brand brand){
        return BrandPriceResponse.builder()
                .brandCd(brand.getBrandCd())
                .brandName(brand.getBrandName())
                .totalPrice(brand.getTotalPrice())
                .build();
    }

    private CategoryPriceRangeResponse createCategoryPriceRangeResponse(String categoryCd){
        return CategoryPriceRangeResponse
                .builder()
                .categoryName(productManager.getCategory(categoryCd).getCategoryName())
                .min(createBrandProductDto(productManager.getProductMinPrice(categoryCd)))
                .max(createBrandProductDto(productManager.getProductMaxPrice(categoryCd)))
                .build();
    }

    private BrandProductDto createBrandProductDto(Product product){
        return BrandProductDto.builder()
                .brandCd(product.getBrandCd())
                .price(product.getPrice())
                .build();
    }

    private MinPriceBrandResponse createMinPriceResponse(Brand brand, List<PriceProductResponse> categoryProductDtoList){
        return MinPriceBrandResponse.builder()
                .brand(brand.getBrandCd())
                .categoryList(categoryProductDtoList)
                .totalPrice(brand.getTotalPrice())
                .build();
    }


    private PriceProductResponse matchCategory(Category category, List<Product> productList){
        return productList.stream()
                .filter(v -> v.getCategoryCd().equals(category.getCategoryCd()))
                .map(v -> {
                    return createProductDto(v, category.getCategoryName());
                })
                .findFirst().orElseThrow(() -> new RecommendationException(ResponseCodeEnum.NOT_FOUND_BRAND_PRODUCT));
    }
    private PriceProductResponse createProductDto(Product product, String categoryName){
        return PriceProductResponse.builder()
                .productNo(product.getProductNo())
                .categoryName(categoryName)
                .brandCd(product.getBrandCd())
                .price(product.getPrice())
                .build();
    }
}
