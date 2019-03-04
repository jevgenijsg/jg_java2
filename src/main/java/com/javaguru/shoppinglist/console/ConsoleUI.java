package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.ProductService;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleUI {

    private final List<Action> actions = new ArrayList<>();

    ProductService productService;

    public ConsoleUI(ProductService productService) {
        this.productService = productService;
    }

    public void start() {
        Action exitAction = new ExitAction();
        Action createUserAction = new CreateProductAction(productService);
        Action findUserByIdAction = new FindProductByIdAction(productService);
        Action findUserByNameAction = new FindProductByNameAction(productService);
        actions.add(createUserAction);
        actions.add(findUserByIdAction);
        actions.add(findUserByNameAction);
        actions.add(exitAction);
        readUserInput();
    }

    private void printMenu() {
        for (int i = 0; i < actions.size(); i++) {
            System.out.println(i + ". " + actions.get(i));
        }
    }

    private void readUserInput() {
        Scanner scanner = new Scanner(System.in);

        int response = 0;

        while (response >= 0) {
            printMenu();
            try {
                response = scanner.nextInt();
                actions.get(response).execute();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
