package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;

import java.util.Optional;

public interface ProductService {

    Long create(Product product);
    Product findBy(Long id);

    Optional<Product> findByName(String name);
}
