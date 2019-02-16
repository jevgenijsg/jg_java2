package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductDiscountValidationRule implements ProductValidationRule {

    private final double minimumDiscount = 0.0;
    private final double maximumDiscount = 100.0;
    private final double minimalAcceptablePriceForDiscount = 20.0;

    @Override
    public void validate(Product product) {
        CheckNotNull(product);
        if (product.getDiscount().doubleValue() > maximumDiscount) {
            throw new ProductValidationException("Discount can't be more than 100% !!! Please try again");
        }
        if (product.getRegularPrice().doubleValue() < minimumDiscount) {
            throw new ProductValidationException("Discount can't be less than 0%");
        }
        if (product.getRegularPrice().doubleValue() < minimalAcceptablePriceForDiscount) {
            product.setDiscountedPrice(product.getRegularPrice());
        }
    }
}
