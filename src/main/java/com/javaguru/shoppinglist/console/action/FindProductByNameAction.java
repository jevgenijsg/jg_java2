package com.javaguru.shoppinglist.console.action;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FindProductByNameAction implements Action {

    private static final String ACTION_NAME = "Find by Name";

    private final ProductService productService;

    @Autowired
    public FindProductByNameAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        Product response = productService.findByName(name);
        System.out.println("Response: " + response);
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
