package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.springframework.stereotype.Component;

@Component
public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        CheckNotNull(product);
        if (product.getName() == null || product.getName().isEmpty()) {
            throw new ProductValidationException("Name must be not null or empty");
        }
    }
}
