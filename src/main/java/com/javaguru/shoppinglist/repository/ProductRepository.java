package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
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

    public Optional<Product> findByName(String name) {
        for (Map.Entry<Long, Product> lookUp : productDatabase.entrySet()) {
            if (lookUp.getValue().getName().equalsIgnoreCase(name)) {
                return Optional.of(lookUp.getValue());
            }
        }
        return Optional.empty();
    }
}
