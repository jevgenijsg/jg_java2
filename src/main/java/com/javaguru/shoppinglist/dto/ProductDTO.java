package com.javaguru.shoppinglist.dto;

import com.javaguru.shoppinglist.domain.Category;
import java.math.BigDecimal;

public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal regularPrice;
    private Category category;
    private String description;
    private BigDecimal discount;
    private BigDecimal discountedPrice;

    public ProductDTO(Long id, String name, BigDecimal regularPrice, Category category, String description, BigDecimal discount, BigDecimal discountedPrice) {
        this.id = id;
        this.name = name;
        this.regularPrice = regularPrice;
        this.category = category;
        this.description = description;
        this.discount = discount;
        this.discountedPrice = discountedPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(BigDecimal regularPrice) {
        this.regularPrice = regularPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }
}
