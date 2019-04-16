package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;

import java.util.List;

public interface ProductService {

    Long create(Product product);

    Product findById(Long id);

    Product findByName(String name);

    void delete(Long id);

    List<Product> findAll();

    void update(Product product);
}
