package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.*;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;


public class DefaultProductService implements ProductService {

    private ProductRepository productRepository = new ProductRepository();
    private ProductValidationService validationService = new ProductValidationService();

    public Product findBy(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be not null");
        }
        return productRepository.findById(id);
    }

    @Override
    public Long create(Product product) {
        validationService.validate(product);
        Product createdProduct = productRepository.createProduct(product);
        return createdProduct.getId();
    }

}
