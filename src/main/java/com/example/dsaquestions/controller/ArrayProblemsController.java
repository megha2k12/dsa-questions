package com.example.dsaquestions.controller;

import com.example.dsaquestions.service.ArrayProblemsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/arrays")
public class ArrayProblemsController {

    private final ArrayProblemsService service;

    public ArrayProblemsController(ArrayProblemsService service) {
        this.service = service;
    }

    @GetMapping
    public List<String> list() {
        return service.listProblems();
    }
}

