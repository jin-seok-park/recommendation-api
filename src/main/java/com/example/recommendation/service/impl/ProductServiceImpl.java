package com.example.recommendation.service.impl;

import com.example.recommendation.domain.Brand;
import com.example.recommendation.domain.Product;
import com.example.recommendation.domain.dto.request.ProductRequest;
import com.example.recommendation.domain.dto.response.DeleteResponse;
import com.example.recommendation.domain.dto.response.ProductResponse;
import com.example.recommendation.exception.ResponseCodeEnum;
import com.example.recommendation.exception.RecommendationException;
import com.example.recommendation.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductManager productManager;
    private final ValidationService validationService;

    private static final int DEFAULT_PRIORITY = 100;


    @Override
    @Transactional
    public ProductResponse getProduct(long productNo) {
        return createProductResponse(productManager.getProduct(productNo));
    }

    /**
     * 신규 등록 상품일 경우 브랜드 코드가 우선적으로 등록되어 있어함
     * 기존 상품이 등록되어 있을 경우 등록이 불가하다 1개만 등록 가능
     */
    @Override
    @Transactional
    public ProductResponse setProduct(ProductRequest productRequest) {
        validationService.validationProduct(productRequest);
        isExistCd(productRequest);
        isExistDuplication(productRequest);

        Product product = createProduct(productRequest);
        productManager.setProduct(product);
        updateTotalPrice(product);
        deleteProductCache(productRequest.getCategoryCd());
        return createProductResponse(product);
    }

    /**
     * 이미 등록된 브랜드/카테고리의 상품만 등록 가능
     */
    private void isExistCd(ProductRequest productRequest){
        //존재하는 브랜드여야 한다.
        isExistBrand(productRequest.getBrandCd());
        //존재하는 카테고리여야 한다.
        productManager.getCategory(productRequest.getCategoryCd());
    }

    private void isExistDuplication(ProductRequest productRequest){
        long count = productManager.countProduct(productRequest.getBrandCd(), productRequest.getCategoryCd());
        if(count > 0){
            //이미 상품이 있어서 등록 불가
            throw new RecommendationException(ResponseCodeEnum.DUPLICATION_FAIL);
        }
    }


    @Override
    @Transactional
    public DeleteResponse deleteProduct(long productNo) {
        Product product = productManager.getProductLock(productNo);
        int deleteCount = productManager.deleteProduct(productNo);
        updateTotalPrice(product);
        deleteProductCache(product.getCategoryCd());
        return createDeleteResponse(deleteCount);
    }

    @Override
    @Transactional
    public ProductResponse changeProduct(ProductRequest productRequest) {
        validationService.validationProduct(productRequest);
        validationService.validationUpdateProduct(productRequest);
        possibleUpdate(productRequest);

        Product product = productManager.getProductLock(productRequest.getProductNo());
        product.updateProductInfo(productRequest);
        updateTotalPrice(product);
        deleteProductCache(product.getCategoryCd());

        return createProductResponse(product);
    }

    private void possibleUpdate(ProductRequest productRequest){
        Product product = productManager.getProduct(productRequest.getProductNo());
        if(product.getBrandCd().equals(productRequest.getBrandCd()) &&
                product.getCategoryCd().equals(productRequest.getCategoryCd())){
            return;
        }
        // 브랜드코드 /카테고리가 변경건이면 다른 대상있는지 확인
        isExistDuplication(productRequest);
    }

    @Transactional
    public void updateTotalPrice(Product product){
        //상품정보가 변경되면 브랜드 전체금액을 업데이트 한다.
        long totalPrice = productManager.getBrandTotalPrice(product.getBrandCd());
        Brand brand = productManager.getBrand(product.getBrandCd());
        brand.updateTotalPrice(totalPrice);
    }

    private ProductResponse createProductResponse(Product product){
        return ProductResponse.builder()
                .productNo(product.getProductNo())
                .categoryCd(product.getCategoryCd())
                .name(product.getName())
                .price(product.getPrice())
                .count(product.getCount())
                .saleStatus(product.getSaleStatus())
                .brandCd(product.getBrandCd())
                .requestUserNo(product.getUpdateUserNo())
                .build();

    }

    private DeleteResponse createDeleteResponse(int deleteCount){
        return DeleteResponse.builder()
                .deleteCount(deleteCount)
                .build();
    }

    private Product createProduct(ProductRequest productRequest){
        return Product.builder()
                .categoryCd(productRequest.getCategoryCd())
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .count(productRequest.getCount())
                .saleStatus(SaleStatusEnum.SALE)
                .brandCd(productRequest.getBrandCd())
                .priority(createDefaultPriority(productRequest.getPriority()))
                .createUserNo(productRequest.getRequestUserNo())
                .updateUserNo(productRequest.getRequestUserNo())
                .build();

    }

    private int createDefaultPriority(int priority){
        return 0 == priority ? DEFAULT_PRIORITY : priority;
    }

    public void deleteProductCache(String brandCd){
        productManager.deleteTotalPriceCache();
        productManager.deleteMinPriceBrandCache();
        productManager.deleteCategoryPriceRangeCache(brandCd);
    }

    private void isExistBrand(String brandCd){
        productManager.getBrand(brandCd);
    }

}
