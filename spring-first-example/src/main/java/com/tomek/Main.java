package com.tomek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GretResponse greeting() {
        GretResponse response = new GretResponse(
                "Hello spring-boot!!",
                List.of("Java", "Python", "JavaScript"),
                new Person("Alex", 35, 145.85)
        );
        return response;
    }

    record Person(String name, int age, double savings) {
    }

    record GretResponse(
            String greet,
            List<String> favProgramingLaguage,
            Person person
    ) {
    }
}
