package com.example.recommendation.domain;

import com.example.recommendation.domain.dto.response.ProductResponse;
import com.example.recommendation.service.ProductManager;
import com.example.recommendation.service.SaleStatusEnum;
import com.example.recommendation.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductDomainTest {

    @Mock
    private ProductManager productManager;

    @InjectMocks
    private ProductServiceImpl productService;

    @DisplayName("상품 DB 조회")
    @Test
    void getProduct() {
        //given
        Product product = Product.builder()
                .productNo(100L)
                .name("상품명")
                .price(9999L)
                .count(1L)
                .saleStatus(SaleStatusEnum.SALE)
                .brandCd("A")
                .priority(100)
                .build();

        when(productManager.getProduct(anyLong())).thenReturn(product);

        //when
        ProductResponse productResponse = productService.getProduct(100L);

        //then
        assertEquals(9999L, productResponse.getPrice());
    }
}
