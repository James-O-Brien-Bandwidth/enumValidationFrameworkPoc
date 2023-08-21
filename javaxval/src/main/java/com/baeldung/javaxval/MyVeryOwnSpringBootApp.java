package com.baeldung.javaxval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyVeryOwnSpringBootApp {

    public static void main(String[] args) {
        SpringApplication.run(MyVeryOwnSpringBootApp.class, args);

        System.out.println("Jimmy. Spring app has started");
    }

}
