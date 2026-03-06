package com.example.dsaquestions.microsoft;

import java.util.*;

public class DsaQuestions {
    public static void main(String[] args) {
        //System.out.print(romanToInt("MCMXCI"));
//        System.out.println(isPalindrome("RaCEACAR"));
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(threeSum(nums));
//        String sentence = "  The quick brown fox jumped   over a lazy dog  ";
//        System.out.println(reverseWords(sentence));
//        System.out.println(removeDuplicates(nums));
//        System.out.println(removeElement(nums, 2));
//        System.out.println(strStr("s", "q"));
//        System.out.println(isPalindromeii("A man, a plan, a canal: Panama"));
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(Arrays.toString(twoSum(nums, 6)));
//        DsaQuestions list = new DsaQuestions();
//        ListNode head = new ListNode(3);
//        list.add(2,head);
//        list.add(4, head);
//        list.add(8, head);
//        list.add(9, head);
//
//        // Print the list
//        System.out.print("L1: ");
//        list.printList(head);
//
//        DsaQuestions list1 = new DsaQuestions();
//        ListNode head1 = new ListNode(2);
//        list1.add(4, head1);
//        list1.add(6, head1);
//        list1.add(3, head1);
//
//        // Print the list
//        System.out.print("L2: ");
//
//        list1.printList(head1);
//
//        System.out.print("L3 ");
//       ListNode l3 = addTwoNumbers(head, head1);
//       list.printList(l3);

//        System.out.print(longestPalindrome("bb"));
        int num1[] = {0};
        int num2[] = {3, 4};
//        System.out.print(maxSubArray(nums));
//        merge1(num1,0,num2,1);
//        System.out.print(findMedianSortedArrays(num1,num2));
        // String[] str = {"eat","eat"};

//        System.out.print(groupAnagrams(str));
//        System.out.print(isPalindrome(101));
//        System.out.print(search(num1,8));
//        System.out.print(reverse(1646324359));
//        System.out.println(kadens(nums));
//        System.out.println(maxReach(num1));
//        System.out.println(Arrays.toString(productOfArray(num1)));


    }

    public static int romanToInt(String s) {
        int no = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        char ch[] = s.toCharArray();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (i < ch.length - 1 && hashMap.get(ch[i]) < hashMap.get(ch[i + 1])) {
                no = no - hashMap.get(ch[i]);
            } else {
                no = no + hashMap.get(ch[i]);
            }
        }
        return no;
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                right--;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            left++;
            right--;
        }
        return true;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0, j = 0, k = nums.length - 1;
        int sum = 0;
        Arrays.sort(nums);
        while (i < nums.length - 2) {
            j = i + 1;
            k = nums.length - 1;
            if (nums[i] > 0) break;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    result.add(triplet);
                    j++;
                    k--;
                }
                if (sum < 0) {
                    j++;

                } else if (sum > 0) {
                    k--;
                }
            }

            i++;
        }

        return result.stream().distinct().toList();
    }

    public static String reverseWords(String sentence) {

        // Replace this placeholder return statement with your code
        //sentence = sentence.trim();
        String[] words = sentence.split("\\s+");
        int i = 0;
        int j = words.length - 1;
        while (i < j) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }
        StringBuilder reversed = new StringBuilder();
        for (String word : words) {
            reversed.append(word).append(" ");
        }
        return reversed.toString().trim();
    }

    public static int removeDuplicates(int[] nums) {
        int k = 0, i = 0, j = i + 1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
                continue;
            }
            nums[k + 1] = nums[j];
            i = j;

            j++;
            k++;
            System.out.println(List.of(nums));
        }
        return k + 1;
    }

    public static int removeElement(int[] nums, int val) {
        int num = 0;
        int i = 0, j = nums.length - 1;//0,1,2,2,3,0,4,2 2
        while (i < nums.length && j > i) {
            if (nums[i] != val) {
                num++;
            } else {
                while (nums[j] == val) {
                    if (j > i) {
                        j--;
                    } else {
                        break;
                    }
                }
                if (nums[j] == val) {
                    break;
                }
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                num++;
                j--;
            }
            i++;
        }
        if (i == j && nums[i] != val) {
            num++;
        }
        return num;
    }

    public static int strStr(String haystack, String needle) {//substring search
        int start = 0;
        int end = 0;
        int i = -1;
        int counter = 0;
        boolean flag = false;
        int j;
        if (needle.length() > haystack.length()) return -1;
        if (needle.isEmpty()) return -1;

        while (start < haystack.length()) {
            i = start;
            counter = 0;
            end = 0;
            j = start;
            while (j < haystack.length() && end < needle.length()) {
//                while(end<needle.length()){
                if (haystack.charAt(j) == needle.charAt(end)) {
                    //start++;
                    end++;
                    counter++;
                    j++;
                } else {
                    flag = false;
                    break;
                }
                flag = true;

//                }
            }
            if (flag)
                break;
            start++;
        }
        if (counter != needle.length()) {
            flag = false;
        }

        return flag ? i : -1;

    }

    public static boolean isPalindromeii(String s) {
        s = s.toLowerCase();
        StringBuilder cleaned = new StringBuilder();
        String[] str = s.split("\\s+");
        for (String st : str) {
            for (char c : st.toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    cleaned.append(c);
                }
            }
        }
        int slow = 0, fast = cleaned.length() - 1;
        while (fast > slow) {
            if (cleaned.charAt(slow) == cleaned.charAt(fast)) {
                slow++;
                fast--;
            } else {
                return false;
            }
        }
        return true;
    }

    public double findMedian() {
        List<Integer> list = new ArrayList<>();
        double median = 0.0;
        int n = list.size();
        int sum = 0;
        if (n % 2 == 0) {
            median = (list.get(n / 2) + list.get((n / 2) - 1)) / 2.0;
        } else {
            median = list.get(n / 2);
        }
        return median;
    }

    public int lengthOfLongestSubstring(String s) {
//        int maxLength = 0;
//        int i=0;
//        int j=-1;
//        Set<Character> set = new HashSet<>();
//        while(i<s.length() && j<s.length()){
//           if(!set.contains(s.charAt(i))){
//               set.add(s.charAt(i));
//                maxLength = Math.max(maxLength, set.size());
//               i++;
//           }else{
//               set.remove(s.charAt(j+1));
//               j++;
//           }
//
//        }
//        return maxLength;

        int maxLength = 0;
        int i = 0;
        int j = -1;
        boolean[] visited = new boolean[256];
        while (j < i && i < s.length()) {
            if (!visited[s.charAt(i)]) {
                visited[s.charAt(i)] = true;
                maxLength = Math.max(maxLength, i - j);
                i++;
            } else {
                visited[s.charAt(j + 1)] = false;
                j++;
            }

        }
        return maxLength;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Pair[] pList = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pList[i] = new Pair(nums[i], i);
        }
        int i = 0;
        int j = pList.length - 1;
        Arrays.sort(pList);
        while (i < j) {
            int sum = pList[i].first + pList[j].first;
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                ans[0] = pList[i].second;
                ans[1] = pList[j].second;
                break;
            }
        }

        return ans;
    }

    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int compareTo(Pair other) {
            return Integer.compare(this.first, other.first);
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ;
        ListNode curr = head;
        ListNode prev = head;
        int sum;
        int carry = 0;


        while (l1 != null || l2 != null || carry != 0) {
            sum = 0;
            sum += carry;

            if (curr == null) {
                curr = new ListNode();
            }
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }

            if (sum >= 10) {
                curr.val = sum % 10;
                carry = sum / 10;
            } else {
                curr.val = sum;
                carry = 0;
            }
            if (prev != curr) {
                prev.next = curr;
                prev = curr;
            }
            curr = curr.next;
        }

        return head;
    }

    public void add(int data, ListNode head) {
        ListNode newNode = new ListNode(data);

        // Traverse to the last node
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Link the new node to the end
        current.next = newNode;
    }

    public void printList(ListNode l1) {
        ListNode current = l1;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static String longestPalindrome(String s) {
        String ans = "";
        int currLen = 0;
        int maxLen = 0;
        int start = 0, e = 0;
        if (s.length() == 1) return s;
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1;
            int j = i + 1;
            currLen = 1;
            while (left >= 0 && j < s.length()) {
                if (s.charAt(left) == s.charAt(j)) {
                    currLen = currLen + 2;

                } else {
                    break;
                }
                left--;
                j++;
            }
            if (currLen > maxLen) {
                maxLen = currLen;
                start = left;
                e = j;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            int left = i;
            int j = i + 1;
            currLen = 0;
            while (left >= 0 && j < s.length()) {
                if (s.charAt(left) == s.charAt(j)) {
                    currLen = currLen + 2;
                } else {
                    break;
                }
                left--;
                j++;
            }
            if (currLen > maxLen) {
                maxLen = currLen;
                start = left;
                e = j;
            }
        }

        ans = s.substring(start + 1, e);
        return ans;
    }

    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = height[0];
        suffixMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
        }
        int left = 0;
        int right = n - 1;
        int val = 0;
        for (int i = 1; i < n; i++) {
            left = prefixMax[i - 1];
            right = suffixMax[i + 1];
            val = Math.max(0, Math.min(left, right) - height[i]);
            sum = sum + val;
        }
        return sum;
    }

    public boolean isValid(String s) {
        boolean ans = false;
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else if (c == ')' && !st.isEmpty() && st.peek() == '(') {
                st.pop();
            } else if (c == ']' && !st.isEmpty() && st.peek() == '[') {
                st.pop();
            } else if (c == '}' && !st.isEmpty() && st.peek() == '{') {
                st.pop();
            } else if (st.isEmpty() && (c == ')' || c == ']' || c == '}')) {
                return false;
            } else {
                return false;
            }
        }
        if (st.isEmpty()) {
            ans = true;
        }
        return ans;
    }

    // Kadane's algorithm
    public static int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int currSum = 0;
        for (int num : nums) {
            currSum += num;
            ans = Math.max(ans, currSum);
            if (currSum < 0) {
                currSum = 0;
            }

        }
        return ans;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        int k = 0, i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                ans[k++] = nums1[i];
                i++;
            } else {
                ans[k++] = nums2[j];
                j++;
            }
        }

        while (i < m) {
            ans[k++] = nums1[i];
            i++;
        }

        while (j < n) {
            ans[k++] = nums2[j];
            j++;
        }
        System.arraycopy(ans, 0, nums1, 0, ans.length);
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {

            nums1[k--] = nums2[j--];
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] ans = new int[m + n];
        double median = 0.00;

        int k = 0, i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                ans[k++] = nums1[i];
                i++;
            } else {
                ans[k++] = nums2[j];
                j++;
            }
        }

        while (i < m) {
            ans[k++] = nums1[i];
            i++;
        }

        while (j < n) {
            ans[k++] = nums2[j];
            j++;
        }
        int l = ans.length;
        if (l % 2 != 0) {
            k = l / 2;
            median = ans[k];
        } else {
            k = l / 2;
            median = ((double) (ans[k] + ans[k - 1]) / 2);
        }

        return median;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            HashMap<Character, Integer> freq = new HashMap<>();
            for (Character c : str.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            List<String> list;
            if (map.containsKey(freq)) {
                list = map.get(freq);

            } else {
                list = new ArrayList<>();

            }
            list.add(str);
            map.put(freq, list);

        }

        return new ArrayList<>(map.values());

    }

    public static boolean isPalindrome(int x) {
        boolean flag = false;
        String s = String.valueOf(x);
        char[] ch = s.toCharArray();
        int i = 0, j = ch.length - 1;
        while (i <= j) {
            if (ch[i] != ch[j]) {
                flag = false;
                break;
            } else {
                flag = true;
                i++;
                j--;
            }
        }
        return flag;
    }

    public static int search(int[] nums, int target) {
        int inx = -1;
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                inx = mid;
                break;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return inx;

    }

    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int n = height.length;
        int right = height.length - 1;
        while (left <= right) {
            int currArea = Math.min(height[left], height[right]) *
                    (right - left);
            ;
            ans = Math.max(ans, currArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;

    }

    public static String longestCommonPrefix(String[] strs) {
        String pref = "";
        Arrays.sort(strs);
        int i = 0;
        int j = strs.length - 1;
        char[] ch = strs[i].toCharArray();
        char[] ch1 = strs[j].toCharArray();

        int k = 0;
        while (k < ch.length && k < ch1.length) {
            if (ch[k] == ch1[k])
                k++;
            else
                break;
        }
        pref = strs[i].substring(0, k);
        return pref;
    }

    public static int reverse(int x) {
        int y = 0;
        while (x != 0) {
            int rev = x % 10;
            if (y >= Integer.MAX_VALUE / 10 || y <= Integer.MIN_VALUE / 10) {
                return 0;
            }
            y = (y * 10) + rev;
            x = x / 10;
        }
        return y;
    }

    public static int kadens(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i : nums) {
            currSum += i;
            maxSum = Math.max(currSum, maxSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static boolean maxReach(int[] nums) {
        int maxReach = 0;
        int currReach;
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (i > maxReach) {
                return false;
            }
            currReach = i + nums[i];
            maxReach = Math.max(maxReach, currReach);

            i++;
            if (maxReach >= n - 1) {
                return true;
            }
        }
        return maxReach >= n - 1;
    }

    public static int[] productOfArray(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefix[i] * suffix[i];
        }
        return nums;

    }


}

