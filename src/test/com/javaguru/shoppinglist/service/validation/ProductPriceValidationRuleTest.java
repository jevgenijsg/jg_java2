package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;


public class ProductPriceValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductPriceValidationRule victim = new ProductPriceValidationRule();

    private Product input;

    @Test

    public void shouldThrowPriceException() {

        input = product(BigDecimal.valueOf(-1));

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Price must be more than zero(0)!!! Please try again");

        victim.validate(input);
    }


    public Product product(BigDecimal price) {
        Product product = new Product();
        product.setRegularPrice(price);
        return product;
    }

}