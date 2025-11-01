package com.example.dsaquestions.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ArrayProblemsService {

    public List<String> listProblems() {
        return Arrays.asList(
                "Two Sum",
                "Maximum Subarray",
                "Merge Intervals",
                "Sort Colors"
        );
    }
}

