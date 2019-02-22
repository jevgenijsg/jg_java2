package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;

public class ProductNameValidationRule implements ProductValidationRule {

    ProductRepository productRepository;

    public ProductNameValidationRule(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void validate(Product product) {
        if ((!productRepository.getProductDatabase().isEmpty()) &&
                (productRepository.findByName(product.getName()).getName().equalsIgnoreCase(product.getName()))) {
            throw new ProductValidationException("Name is already taken");
        }
    }
}




