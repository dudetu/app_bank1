package com.example.app_bank1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:variables.properties")
@SpringBootApplication
public class AppBank1Application {

    public static void main(String[] args) {
        SpringApplication.run(AppBank1Application.class, args);
    }

}
