package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;

import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {

    private Set<ProductValidationRule> validationRules = new HashSet<>();
    ProductRepository productRepository;


    public ProductValidationService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        validationRules.add(new ProductDescriptionValidationRule());
        validationRules.add(new ProductDiscountValidationRule());
        validationRules.add(new ProductPriceValidationRule());
        validationRules.add(new ProductNameValidationRule(productRepository));

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
