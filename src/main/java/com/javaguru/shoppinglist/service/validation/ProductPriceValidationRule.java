package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class ProductPriceValidationRule implements ProductValidationRule {

    private static final BigDecimal acceptableMinimumPrice = BigDecimal.valueOf((0.0));

    @Override
    public void validate(Product product) {
        CheckNotNull(product);
        if (product.getRegularPrice().compareTo(acceptableMinimumPrice) <= 0) {
            throw new ProductValidationException("Price must be more than zero(0)!!! Please try again");
        }
    }
}
