package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductDescriptionValidationRuleTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductDescriptionValidationRule victim = new ProductDescriptionValidationRule();

    private Product input;

    @Test
    public void shouldThrowProductNameValidationException() {
        input = product(null);

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Description must be more than 3 and less than 32 characters!!! Please try again");

        victim.validate(input);
    }

    @Test
    public void shouldThrowDescriptionExceptionIfLessThanTwo() {
        input = product("ab");

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Description must be more than 3 and less than 32 characters!!! Please try again");

        victim.validate(input);
    }

    @Test
    public void shouldThrowDescriptionExceptionIfMoreThanThirtyTwo() {
        input = product("123456789123456789123456789123456789");

        expectedException.expect(ProductValidationException.class);
        expectedException.expectMessage("Description must be more than 3 and less than 32 characters!!! Please try again");

        victim.validate(input);
    }

    private Product product(String description) {
        Product product = new Product();
        product.setDescription(description);
        return product;
    }
}