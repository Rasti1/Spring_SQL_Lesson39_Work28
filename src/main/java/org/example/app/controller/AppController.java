package org.example.app.controller;

import org.example.app.entity.Product;
import org.example.app.service.ProductService;
import org.example.app.utils.Constants;
import org.example.app.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AppController {

    @Autowired
    AppView menuView;
    @Autowired
    CreateProductView createView;
    @Autowired
    ReadProductView readView;
    @Autowired
    ReadByIdProductView readByIdView;
    @Autowired
    UpdateProductView updateView;
    @Autowired
    DeleteProductView deleteView;
    @Autowired
    ProductService service;

    public void runApp(){

        while(true){

            int option = menuView.getMenu();

            switch (option){
                case 1 -> {
                    Object[] data = createView.getData();
                    Product product = new Product((String) data[0],
                            (Integer) data[1], (Double) data[2]);
                    String message = service.create(product);
                    createView.getOutput(message);
                }
                case 2 -> {
                    String output = service.getAll();
                    readView.getOutput(output);
                }
                case 3 -> {
                    Map<String, String> data = updateView.getData();
                    Product product = new Product(data.get("name"),
                            Integer.parseInt(data.get("quota")),
                            Double.parseDouble(data.get("price")));
                    String message = service.update(product);
                    updateView.getOutput(message);
                }
                case 4 -> {
                    String id = deleteView.getData();
                    String message = service.delete(id);
                    deleteView.getOutput(message);
                }
                case 5 -> {
                    String id = readByIdView.getData();
                    String output = service.getById(id);
                    readByIdView.getOutput(output);
                }
                case 0 -> {
                    menuView.getOutput(Constants.APP_CLOSE_MSG);
                    System.exit(0);
                }
                default -> menuView.getOutput(Constants.INCORRECT_VALUE_MSG);
            }
        }
    }
}
