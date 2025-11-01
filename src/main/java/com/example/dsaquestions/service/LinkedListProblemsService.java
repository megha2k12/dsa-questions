package com.example.dsaquestions.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LinkedListProblemsService {

    public List<String> listProblems() {
        return Arrays.asList(
                "Reverse Linked List",
                "Merge Two Sorted Lists",
                "Linked List Cycle",
                "Remove Nth Node From End of List"
        );
    }
}

