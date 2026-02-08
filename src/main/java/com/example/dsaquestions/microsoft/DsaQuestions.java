package com.example.dsaquestions.microsoft;

import java.util.*;

public class DsaQuestions {
    public static void main(String[] args) {
        //System.out.print(romanToInt("MCMXCI"));
//        System.out.println(isPalindrome("RaCEACAR"));
        int[] nums = {3,2,4 };
//        System.out.println(threeSum(nums));
//        String sentence = "  The quick brown fox jumped   over a lazy dog  ";
//        System.out.println(reverseWords(sentence));
//        System.out.println(removeDuplicates(nums));
//        System.out.println(removeElement(nums, 2));
//        System.out.println(strStr("s", "q"));
//        System.out.println(isPalindromeii("A man, a plan, a canal: Panama"));
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(Arrays.toString(twoSum(nums, 6)));
        DsaQuestions list = new DsaQuestions();
        ListNode head = new ListNode(3);
        list.add(2,head);
        list.add(4, head);
        list.add(8, head);
        list.add(9, head);

        // Print the list
        System.out.print("L1: ");
        list.printList(head);

        DsaQuestions list1 = new DsaQuestions();
        ListNode head1 = new ListNode(2);
        list1.add(4, head1);
        list1.add(6, head1);
        list1.add(3, head1);

        // Print the list
        System.out.print("L2: ");

        list1.printList(head1);

        System.out.print("L3 ");
       ListNode l3 = addTwoNumbers(head, head1);
       list.printList(l3);


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
        int i = 0, j = nums.length-1;//0,1,2,2,3,0,4,2 2
        while(i<nums.length && j>i){
            if(nums[i]!=val){
                num++;
            }else{
                while(nums[j]==val){
                    if(j>i) {
                        j--;
                    }else {
                        break;
                    }
                }
                if(nums[j] == val){
                    break;
                }
                int temp = nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                num++;
                j--;
            }
        i++;
        }
        if(i==j && nums[i]!=val){
           num++;
        }
        return num;
    }
    public static int strStr(String haystack, String needle) {//substring search
        int start = 0;
        int end = 0;
        int i =-1;
        int counter =0;
        boolean flag = false;
        int j;
        if(needle.length() > haystack.length()) return -1;
        if(needle.isEmpty()) return -1;

        while(start < haystack.length()){
            i=start;
            counter=0;
            end = 0;
            j= start;
            while(j<haystack.length() && end<needle.length()){
//                while(end<needle.length()){
                    if(haystack.charAt(j) == needle.charAt(end)){
                        //start++;
                        end++;
                        counter++;
                        j++;
                    }else{
                        flag = false;
                        break;
                    }
                    flag = true;

//                }
            }
            if(flag)
                break;
            start++;
        }
        if(counter != needle.length()){
            flag = false;
        }

        return flag ? i : -1;

    }
    public static boolean isPalindromeii(String s) {
        s = s.toLowerCase();
        StringBuilder cleaned = new StringBuilder();
        String[] str = s.split("\\s+");
        for(String st:str){
            for(char c:st.toCharArray()){
                if(Character.isLetterOrDigit(c)){
                    cleaned.append(c);
                }
            }
        }
        int slow=0,fast = cleaned.length()-1;
        while(fast>slow) {
            if (cleaned.charAt(slow) == cleaned.charAt(fast)) {
                slow++;
                fast--;
            }else{
                return false;
            }
        }
        return true;
    }

    public double findMedian() {
        List<Integer> list = new ArrayList<>();
        double median = 0.0;
        int n = list.size();
        int sum =0;
        if( n % 2 == 0){
            median = (list.get(n/2)+ list.get((n/2)-1))/2.0;
        }else{
            median = list.get(n/2);
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
        int i=0;
        int j=-1;
        boolean[] visited = new boolean[256];
        while(j<i && i<s.length()){
            if(!visited[s.charAt(i)]){
                visited[s.charAt(i)] = true;
                maxLength = Math.max(maxLength, i-j);
                i++;
            }else{
                visited[s.charAt(j+1)] = false;
                j++;
            }

        }
        return maxLength;
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Pair[] pList = new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            pList[i] = new Pair(nums[i],i);
        }
        int i=0;
        int j = pList.length-1;
        Arrays.sort(pList);
         while(i<j){
             int sum = pList[i].first+pList[j].first;
             if(sum > target){
                j--;
             }else if(sum < target){
                 i++;
             }else{
                 ans[0] = pList[i].second;
                 ans[1] = pList[j].second;
                 break;
             }
         }

        return ans;
    }

static class Pair implements Comparable<Pair>{
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
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();;
        ListNode curr = head;
        ListNode prev = head;
        int sum ;
        int carry = 0;


        while(l1 !=null || l2 != null || carry !=0){
            sum = 0;
            sum += carry;

            if(curr == null){
                curr = new ListNode();
            }
            if(l1 != null){
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }

            if (sum >= 10) {
                curr.val = sum % 10;
                carry = sum / 10;
            }else{
                curr.val = sum;
                carry = 0;
            }
            if(prev != curr){
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
}
