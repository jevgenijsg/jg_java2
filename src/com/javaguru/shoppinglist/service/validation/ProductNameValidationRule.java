package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;

import java.util.Map;


public class ProductNameValidationRule implements ProductValidationRule {

    ProductRepository productRepository;

    public ProductNameValidationRule(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void validate(Product product) {
        if (!productRepository.getProductDatabase().isEmpty()) {
            for (Map.Entry<Long, Product> lookUp : productRepository.getProductDatabase().entrySet()) {
                if (lookUp.getValue().getName().equalsIgnoreCase(product.getName())) {
                    throw new ProductValidationException("Name is already taken");
                }
            }
        }
    }
}



