package com.sangle.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
@ServletComponentScan
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MainApplication.class);
        // Enable debug logging
        app.setLogStartupInfo(true);

        // Add a custom listener for events
        app.addListeners((ApplicationListener<ApplicationEvent>) event -> {
            System.out.println("Spring Event: " + event.getClass().getName());
        });
        // Run the application in debug mode
        app.run(args);
    }
}