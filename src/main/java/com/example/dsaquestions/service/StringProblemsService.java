package com.example.dsaquestions.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StringProblemsService {

    public List<String> listProblems() {
        return Arrays.asList(
                "Longest Substring Without Repeating Characters",
                "Valid Anagram",
                "Group Anagrams",
                "Longest Palindromic Substring"
        );
    }




}





