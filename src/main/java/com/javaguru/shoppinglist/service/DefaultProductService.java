package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.*;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;
    private final ProductValidationService validationService;

    @Autowired
    public DefaultProductService(ProductRepository productRepository, ProductValidationService validationService) {
        this.productRepository = productRepository;
        this.validationService = validationService;
    }

    public Optional<Product> findById(Long id) {
        validationService.validateId(id);
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Long create(Product product) {
        calculateDiscountedPrice(product);
        validationService.validate(product);
        Long createdProduct = productRepository.createProduct(product);
        return createdProduct;
    }

    private void calculateDiscountedPrice(Product product) {
        BigDecimal discountValue = (product.getRegularPrice().multiply(product.getDiscount())).divide(BigDecimal.valueOf(100));
        BigDecimal finalDiscountPrice = product.getRegularPrice().subtract(discountValue);
        product.setDiscountedPrice(finalDiscountPrice);
    }
}
