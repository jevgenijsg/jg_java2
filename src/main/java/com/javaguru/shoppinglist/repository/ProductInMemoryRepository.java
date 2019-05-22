/*package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Profile("inmemorydb")
public class ProductInMemoryRepository implements ProductRepository {

    private Map<Long, Product> productDatabase = new HashMap<>();
    private Long productIdSequence = 0L;

    @Override
    public Long createProduct(Product product) {
        product.setId(productIdSequence);
        productDatabase.put(productIdSequence, product);
        productIdSequence++;
        return product.getId();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(productDatabase.get(id));
    }

    @Override
    public Optional<Product> findByName(String name) {
        for (Map.Entry<Long, Product> lookUp : productDatabase.entrySet()) {
            if (lookUp.getValue().getName().equalsIgnoreCase(name)) {
                return Optional.of(lookUp.getValue());
            }
        }
        return Optional.empty();
    }
}*/
