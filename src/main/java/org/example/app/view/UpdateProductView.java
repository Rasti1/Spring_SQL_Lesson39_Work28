package org.example.app.view;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class UpdateProductView {

    public Map<String, String> getData() {
        Map<String, String> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input product name: ");
        map.put("name", scanner.nextLine().trim());

        System.out.print("Input quota: ");
        while (true) {
            String quota = scanner.nextLine().trim();
            try {
                Integer.parseInt(quota);
                map.put("quota", quota);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid integer for quota: ");
            }
        }

        System.out.print("Input price: ");
        while (true) {
            String price = scanner.nextLine().trim();
            try {
                Double.parseDouble(price);
                map.put("price", price);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid number for price: ");
            }
        }
        return map;
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
