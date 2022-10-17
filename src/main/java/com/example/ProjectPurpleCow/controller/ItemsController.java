package com.example.ProjectPurpleCow.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController {
    @GetMapping("/items")
    public String items() {
        return "items";
    }
}
