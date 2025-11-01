package com.example.dsaquestions.controller;

import com.example.dsaquestions.service.StringProblemsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/strings")
public class StringProblemsController {

    private final StringProblemsService service;

    public StringProblemsController(StringProblemsService service) {
        this.service = service;
    }

    @GetMapping
    public List<String> list() {
        return service.listProblems();
    }
}

