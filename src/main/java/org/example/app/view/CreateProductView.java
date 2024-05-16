package org.example.app.view;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CreateProductView {

    public Object[] getData() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input product name: ");
            String productName = scanner.nextLine().trim();

            System.out.print("Input quota: ");
            Integer quota = null;
            while (quota == null) {
                try {
                    quota = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter a valid integer for quota: ");
                }
            }

            System.out.print("Input price: ");
            Double price = null;
            while (price == null) {
                try {
                    price = Double.parseDouble(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter a valid number for price: ");
                }
            }

            return new Object[]{productName, quota, price};
        }
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
