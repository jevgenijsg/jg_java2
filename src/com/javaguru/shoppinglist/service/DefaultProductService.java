package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.*;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import java.math.BigDecimal;


public class DefaultProductService implements ProductService {

    private ProductRepository productRepository = new ProductRepository();
    private ProductValidationService validationService = new ProductValidationService(productRepository);

    public Product findBy(Long id) {
        validationService.validateId(id);
        return productRepository.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Long create(Product product) {
        calculateDiscountedPrice(product);
        validationService.validate(product);
        Product createdProduct = productRepository.createProduct(product);
        return createdProduct.getId();
    }

    private void calculateDiscountedPrice(Product product) {
        BigDecimal discountValue = (product.getRegularPrice().multiply(product.getDiscount())).divide(BigDecimal.valueOf(100));
        BigDecimal finalDiscountPrice = product.getRegularPrice().subtract(discountValue);
        product.setDiscountedPrice(finalDiscountPrice);
    }
}
