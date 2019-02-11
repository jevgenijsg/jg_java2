package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductDescriptionValidationRule implements ProductValidationRule {


    @Override
    public void validate(Product product) {
        CheckNotNull(product);
        if (product.getDescription().length() < 3 || product.getDescription().length() > 32) {
            throw new ProductValidationException("Description must be more than 3 and less than 32 characters!!! Please try again");
        }
    }
}
