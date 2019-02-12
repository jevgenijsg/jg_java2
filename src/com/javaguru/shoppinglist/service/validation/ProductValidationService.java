package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {

    private Set<ProductValidationRule> validationRules = new HashSet<>();

    public ProductValidationService() {
        validationRules.add(new ProductDescriptionValidationRule());
        validationRules.add(new ProductDiscountValidationRule());
        validationRules.add(new ProductPriceValidationRule());
    }

    public void validate(Product product) {
        validationRules.forEach(s -> s.validate(product));
    }

    public void validateId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be not null");
        }
    }
}
