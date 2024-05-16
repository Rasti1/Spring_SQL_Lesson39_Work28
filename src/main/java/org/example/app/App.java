package org.example.app;

import org.example.app.config.AppConfig;
import org.example.app.controller.AppController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        AppController appController = context.getBean(AppController.class);
        appController.runApp();

    }
}
