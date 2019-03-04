package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.springframework.stereotype.Component;

@Component
public class ProductDescriptionValidationRule implements ProductValidationRule {

    private final int minimumNumberOfChars = 3;
    private final int maximumNumberOfChars = 32;

    @Override
    public void validate(Product product) {
        CheckNotNull(product);
        if (product.getDescription() == null || product.getDescription().length() < minimumNumberOfChars || product.getDescription().length() > maximumNumberOfChars) {
            throw new ProductValidationException("Description must be more than 3 and less than 32 characters!!! Please try again");
        }
    }
}
