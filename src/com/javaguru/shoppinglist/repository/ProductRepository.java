package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private Map<Long, Product> productDatabase = new HashMap<>();
    private Long productIdSequence = 0L;


    public Product createProduct(Product product) {
        product.setId(productIdSequence);
        productDatabase.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }

    public Product findById(Long id) {
        return productDatabase.get(id);
    }
}
