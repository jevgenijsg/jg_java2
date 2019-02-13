package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.service.DefaultProductService;
import com.javaguru.shoppinglist.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final List<Action> actions = new ArrayList<>();

    public void start() {

        ProductService productService = new DefaultProductService();
        Action exitAction = new ExitAction();
        Action createUserAction = new CreateProductAction(productService);
        Action findUserByIdAction = new FindProductByIdAction(productService);
        actions.add(findUserByIdAction);
        actions.add(createUserAction);
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
