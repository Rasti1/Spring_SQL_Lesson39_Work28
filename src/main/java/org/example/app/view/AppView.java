package org.example.app.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AppView {

    static final Scanner sc = new Scanner(System.in);

    public int getMenu() {
        System.out.print("""
                OPTIONS:
                1 - Create product.
                2 - Read products.
                3 - Update product.
                4 - Delete product.
                5 - Read product by id.
                0 - Close the App.
                """);
        System.out.print("Input your option: ");
        int option = sc.nextInt();
        sc.nextLine();
        return option;
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
