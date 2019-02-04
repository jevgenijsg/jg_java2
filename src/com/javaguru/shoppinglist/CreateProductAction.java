package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateProductAction implements Action {

    private static final String ACTION_NAME = "Create Product";

    private final ProductService productService;

    public CreateProductAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();

        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        product.setName(name);

        System.out.println("Enter product price: ");
        String price = scanner.nextLine();
        product.setPrice(new BigDecimal(price));

        System.out.println("Enter product category. Choose one of the following : ");
        for (Category categoryValue : Category.values()
        ) {
            System.out.print(categoryValue + " ");
        }
        String category = scanner.nextLine().toUpperCase();
        product.setCategory(Category.valueOf(category));

        System.out.println("Enter product discount: ");
        String discount = scanner.nextLine();
        product.setDiscount(new BigDecimal(discount));

        System.out.println("Enter product description: ");
        String description = scanner.nextLine();
        product.setDescription(description);


        try {
            Long response = productService.create(product);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
