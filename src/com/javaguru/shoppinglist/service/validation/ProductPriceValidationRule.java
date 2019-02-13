package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductPriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        CheckNotNull(product);
        if (product.getPrice().doubleValue() <= 0) {
            throw new ProductValidationException("Price must be more than zero(0)!!! Please try again");
        }
    }
}
