package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.*;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;
    private final ProductValidationService validationService;

    @Autowired
    public DefaultProductService(ProductRepository productRepository, ProductValidationService validationService) {
        this.productRepository = productRepository;
        this.validationService = validationService;
    }

    @Transactional
    public Long create(Product product) {
        calculateDiscountedPrice(product);
        validationService.validate(product);
        return productRepository.createProduct(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not fount : " + id));
    }

    public Product findByName(String name) {
        return productRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException("Product not found : " + name));
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }


    private void calculateDiscountedPrice(Product product) {
        BigDecimal discountValue = (product.getRegularPrice().multiply(product.getDiscount())).divide(BigDecimal.valueOf(100));
        BigDecimal finalDiscountPrice = product.getRegularPrice().subtract(discountValue);
        product.setDiscountedPrice(finalDiscountPrice);
    }
}
