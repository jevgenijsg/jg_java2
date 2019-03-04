package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductNameValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductNameValidationRule victim = new ProductNameValidationRule();
    private Product input;

    @Test
    public void shouldThrowNameExceptionIfNull() {
        input = product(null);

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Name must be not null or empty");
        victim.validate(input);
    }


    @Test
    public void shouldThrowNameExceptionIfEmpty() {
        input = product("");

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Name must be not null or empty");
        victim.validate(input);
    }


    private Product product(String name) {
        Product product = new Product();
        product.setName(name);
        return product;
    }

}