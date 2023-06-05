package com.example.recommendation.service;

import com.example.recommendation.domain.Brand;
import com.example.recommendation.domain.Category;
import com.example.recommendation.domain.Product;
import com.example.recommendation.domain.repository.BrandRepository;
import com.example.recommendation.domain.repository.CategoryRepository;
import com.example.recommendation.domain.repository.ProductRepository;
import com.example.recommendation.exception.ResponseCodeEnum;
import com.example.recommendation.exception.RecommendationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductManager {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    @CacheEvict(value = "totalPriceCache")
    public void deleteTotalPriceCache(){
    }

    @CacheEvict(value = "minPriceBrandCache")
    public void deleteMinPriceBrandCache(){
    }

    @CacheEvict(value = "categoryPriceRangeCache", key = "#categoryCd")
    public void deleteCategoryPriceRangeCache(String categoryCd){
    }

    public Brand getMinPriceBrand(){
        return brandRepository.findFirstByOrderByTotalPrice()
                .orElseThrow(() -> new RecommendationException(ResponseCodeEnum.NOT_FOUND_BRAND));
    }

    public long getBrandProductCount(String brandCd){
        return productRepository.findByBrandCd(brandCd).map(List::size).orElse(0);
    }

    public List<Product> getBrandAllProduct(String brandCd){
        return productRepository.findByBrandCd(brandCd)
                .orElseThrow(() -> new RecommendationException(ResponseCodeEnum.NOT_FOUND_PRODUCT));
    }

    public Product getProductMinPrice(String categoryCd){
        return productRepository.findFirstByCategoryCdOrderByPriceAscPriorityAsc(categoryCd)
                .orElseThrow(() -> new RecommendationException(ResponseCodeEnum.NOT_FOUND_PRODUCT));
    }

    public Product getProductMaxPrice(String categoryCd){
        return productRepository.findFirstByCategoryCdOrderByPriceDescPriorityAsc(categoryCd)
                .orElseThrow(() -> new RecommendationException(ResponseCodeEnum.NOT_FOUND_PRODUCT));
    }

    public Category getCategory(String categoryCd) {
        return categoryRepository.findByCategoryCd(categoryCd)
                .orElseThrow(() -> new RecommendationException(ResponseCodeEnum.NOT_FOUND_CATEGORY));
    }

    public List<Category> getCategoryList(){
        return categoryRepository.findAllByOrderByPriority()
                .orElseThrow(() -> new RecommendationException(ResponseCodeEnum.NOT_FOUND_CATEGORY));
    }

    public Brand getBrand(String brandCd){
        return brandRepository.findByBrandCd(brandCd)
                .orElseThrow(() -> new RecommendationException(ResponseCodeEnum.NOT_FOUND_BRAND));
    }

    public Brand setBrand(Brand brand){
        return brandRepository.save(brand);
    }

    public int deleteBrand(String brandCd) {
        int deleteCount = brandRepository.deleteByBrandCd(brandCd);
        if(deleteCount == 0){
            throw new RecommendationException(ResponseCodeEnum.DELETE_BRAND_FAIL);
        }
        return deleteCount;
    }

    public Product setProduct(Product product){
        return productRepository.save(product);
    }

    public int deleteProduct(long productNo) {
        int deleteCount = productRepository.deleteByProductNo(productNo);
        if(deleteCount == 0){
            throw new RecommendationException(ResponseCodeEnum.DELETE_PRODUCT_FAIL);
        }
        return deleteCount;
    }

    public Product getProduct(long productNo){
        return productRepository.findById(productNo)
                .orElseThrow(() -> new RecommendationException(ResponseCodeEnum.NOT_FOUND_PRODUCT));
    }

    public Product getProductLock(long productNo) {
        return productRepository.findByProductNo(productNo)
                .orElseThrow(() -> new RecommendationException(ResponseCodeEnum.NOT_FOUND_PRODUCT));
    }

    public long countProduct(String brandCd, String categoryCd){
        return productRepository.findByBrandCdAndCategoryCd(brandCd, categoryCd)
                .orElseThrow(() -> new RecommendationException(ResponseCodeEnum.NOT_FOUND_PRODUCT)).size();
    }

    public List<Brand> getAllBrand(){
        return brandRepository.findAll();
    }

    public long getBrandTotalPrice(String brandCd){
        List<Product> productList = getBrandAllProduct(brandCd);
        return productList.stream().mapToLong(Product::getPrice).sum();
    }

}
