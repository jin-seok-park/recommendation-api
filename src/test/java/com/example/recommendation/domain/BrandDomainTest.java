package com.example.recommendation.domain;

import com.example.recommendation.domain.dto.response.CategoryPriceRangeResponse;
import com.example.recommendation.service.ProductManager;
import com.example.recommendation.service.SaleStatusEnum;
import com.example.recommendation.service.impl.RecommendationServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BrandDomainTest {

    @Mock
    private ProductManager productManager;

    @InjectMocks
    private RecommendationServiceImpl recommendationService;


    @DisplayName("브랜드 DB 조회")
    @Test
    void getBrand() {
        //given
        Category category = Category.builder().categoryCd("TOP").categoryName("상의").priority(1).build();
        Product minProduct = Product.builder()
                .productNo(1L)
                .name("C브랜드 상의")
                .price(10000L)
                .count(1L)
                .saleStatus(SaleStatusEnum.SALE)
                .brandCd("C")
                .build();
        Product maxProduct = Product.builder()
                .productNo(2L)
                .name("I브랜드 상의")
                .price(11400L)
                .count(1L)
                .saleStatus(SaleStatusEnum.SALE)
                .brandCd("I")
                .build();

        when(productManager.getCategory(any())).thenReturn(category);
        when(productManager.getProductMinPrice(any())).thenReturn(minProduct);
        when(productManager.getProductMaxPrice(any())).thenReturn(maxProduct);

        //when
        CategoryPriceRangeResponse categoryPriceRangeResponse = recommendationService.getCategoryPriceRange("TOP");

        //then
        assertEquals("상의", categoryPriceRangeResponse.getCategoryName());
    }
}
