package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductPriceValidationRule implements ProductValidationRule {

    private final double acceptableMinimumPrice = 0.0;

    @Override
    public void validate(Product product) {
        CheckNotNull(product);
        if (product.getRegularPrice().doubleValue() <= acceptableMinimumPrice) {
            throw new ProductValidationException("Price must be more than zero(0)!!! Please try again");
        }
    }
}
