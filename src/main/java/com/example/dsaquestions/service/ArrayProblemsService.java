package com.example.dsaquestions.service;

import org.springframework.stereotype.Service;

import java.util.*;

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
    /**
     * Returns true if the input array contains any duplicate values.
     * This implementation runs in O(n) time and O(n) additional space.
     *
     * @param nums the input array (may be null)
     * @return true if any value appears more than once, false otherwise
     */
    public boolean hasDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            // add returns false if the element was already present
            if (!seen.add(n)) {
                return true;
            }
        }
        return false;
    }
    public boolean isAnagram(String s, String t) {
        // Handle nulls: consider nulls not anagrams of any string (including another null)
        if (s == null || t == null) return false;

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer count = freq.get(c);
            if (count == null) {
                return false;
            }
            if (count == 1) {
                freq.remove(c);
            } else {
                freq.put(c, count - 1);
            }
        }

        // if all counts matched, freq should be empty
        return freq.isEmpty();
    }
}
