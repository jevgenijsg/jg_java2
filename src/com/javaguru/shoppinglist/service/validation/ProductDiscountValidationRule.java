package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule {

    private static final BigDecimal minimumDiscount = BigDecimal.valueOf(0.0);
    private static final BigDecimal maximumDiscount = BigDecimal.valueOf(100.0);
    private static final BigDecimal minimalAcceptablePriceForDiscount = BigDecimal.valueOf(20.0);

    @Override
    public void validate(Product product) {
        CheckNotNull(product);
        if (product.getDiscount().compareTo(maximumDiscount) > 0) {
            throw new ProductValidationException("Discount can't be more than 100% !!! Please try again");
        }
        if (product.getDiscount().compareTo(minimumDiscount) < 0) {
            throw new ProductValidationException("Discount can't be less than 0%");
        }
        if (product.getRegularPrice().compareTo(minimalAcceptablePriceForDiscount) < 0) {
            product.setDiscountedPrice(product.getRegularPrice());
        }
    }
}
