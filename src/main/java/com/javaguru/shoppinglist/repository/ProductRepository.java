package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Long createProduct(Product product);

    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    void delete(Long id);

    List<Product> findAll();

    void update(Product product);
}
