package com.example.app_bank1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@EntityScan(basePackages = "com.example.app_bank1.other_paymens.categories")
@PropertySource(value = "classpath:variables.properties")
@SpringBootApplication
public class AppBank1Application {

    public static void main(String[] args) {
        SpringApplication.run(AppBank1Application.class, args);
    }



    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
        }



