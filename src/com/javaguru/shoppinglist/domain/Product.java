package com.javaguru.shoppinglist.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Long id;
    private String name;
    private BigDecimal regularPrice;
    private Category category;
    private String description;
    private BigDecimal discount;
    private BigDecimal discountedPrice;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(regularPrice, product.regularPrice) &&
                category == product.category &&
                Objects.equals(description, product.description) &&
                Objects.equals(discount, product.discount) &&
                Objects.equals(discountedPrice, product.discountedPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, regularPrice, category, description, discount, discountedPrice);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", regularPrice=" + regularPrice +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", discountedPrice=" + discountedPrice +
                '}';
    }
}