package com.example.dsaquestions.controller;

import com.example.dsaquestions.service.LinkedListProblemsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/linkedlists")
public class LinkedListProblemsController {

    private final LinkedListProblemsService service;

    public LinkedListProblemsController(LinkedListProblemsService service) {
        this.service = service;
    }

    @GetMapping
    public List<String> list() {
        return service.listProblems();
    }
}

