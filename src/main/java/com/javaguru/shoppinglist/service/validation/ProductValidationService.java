package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductValidationService {

    private Set<ProductValidationRule> validationRules;

    @Autowired
    public ProductValidationService(Set<ProductValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate(Product product) {
        validationRules.forEach(s -> s.validate(product));
    }
}
