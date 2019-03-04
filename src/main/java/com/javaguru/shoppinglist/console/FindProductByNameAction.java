package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;

import java.util.Optional;
import java.util.Scanner;

public class FindProductByNameAction implements Action {

    private static final String ACTION_NAME = "Find by Name";

    private final ProductService productService;

    public FindProductByNameAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        Optional<Product> response = productService.findByName(name);
        System.out.println("Response: " + response);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
