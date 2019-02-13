package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        CheckNotNull(product);
        if (product.getDiscount().doubleValue() > 100) {
            throw new ProductValidationException("Discount can't be more than 100% !!! Please try again");
        }
    }
}
