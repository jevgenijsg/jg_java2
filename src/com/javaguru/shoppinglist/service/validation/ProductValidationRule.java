package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public interface ProductValidationRule {

    void validate(Product product);


    default void CheckNotNull(Product product) {
        if (product == null) {
            throw new ProductValidationException("Product must no be null");
        }
    }
}
