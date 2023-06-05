package com.example.recommendation.service;

import com.example.recommendation.domain.dto.request.ProductRequest;
import com.example.recommendation.domain.dto.response.DeleteResponse;
import com.example.recommendation.domain.dto.response.ProductResponse;

public interface ProductService {

    ProductResponse getProduct(long productNo);

    ProductResponse setProduct(ProductRequest productRequest);

    DeleteResponse deleteProduct(long productNo);

    ProductResponse changeProduct(ProductRequest productRequest);

}
