package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello from Spring Boot + Docker + Kubernetes!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Kubernetes!";
    }

    @GetMapping("/employee")
    public String employee() {
        return "Employee: 015, Name: Rithesh";
    }
}

//cd "/Users/ritheshmekala/Desktop/3-1/SOA/spring-k8s-demo"
// ./mvnw spring-boot:run