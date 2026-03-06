package com.example.dsaquestions.microsoft;

import java.util.*;

public class ProblemsOnTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);


        System.out.println(printTree(root));
//        System.out.println(invertTree(root));
//        levelOrder(root);
        leftView(root);
//        rightView(root);

//        System.out.println(depthOfTree(root));
//        System.out.println(symmetry(root));
    }

    public static int depthOfTree(TreeNode root) {
        if (root == null) return 0;
        return 1+Math.max(depthOfTree(root.left),depthOfTree(root.right));
    }
    public static boolean symmetry(TreeNode root) {
        if (root == null) return true;
        return findSymm(root.left,root.right);
    }
    public static boolean findSymm(TreeNode left,TreeNode right) {
        if (left == null && right == null) return true;
        if(left == null || right == null) return false;
        return ((left.val == right.val) && findSymm(left.right,right.left) && findSymm(left.left,right.right));
    }
    public static  TreeNode invertTree(TreeNode root){
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;


    }
    public static  boolean sameTree(TreeNode leftTree,TreeNode rightTree){
      if(leftTree == null && rightTree == null) return true;
      if(leftTree == null || rightTree == null) return false;
      if(leftTree.val != rightTree.val) return false;
      return(sameTree(leftTree.left,rightTree.left) &&sameTree(leftTree.right,rightTree.right));
    }
    public static  boolean targetSum(TreeNode root,int target){
       if(root == null) return false;
       if(root.left == null && root.right == null) return (target == root.val);
       return (targetSum(root.left,target-root.val) || (targetSum(root.right,target-root.val)));
    }

    public static void levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) { return;}
        Queue<TreeNode> s = new ArrayDeque<>();
        s.add(root);

        while(!s.isEmpty()){
            int n = s.size();
            List<Integer> level = new ArrayList<>();
            for(int i =0;i<n;i++){
                TreeNode c = s.poll();
                level.add(c.val);
                if(c.left!=null) s.add(c.left);
                if(c.right!=null) s.add(c.right);
            }

            res.add(level);
        }

        System.out.println(res);

    }
    public static void rightView(TreeNode root){
        List<Integer> level = new ArrayList<>();
        if(root == null) { return;}
        Queue<TreeNode> s = new ArrayDeque<>();
        s.add(root);

        while(!s.isEmpty()){
            int n = s.size();

            for(int i =0;i<n;i++){
                TreeNode c = s.poll();
                if(i == n-1){
                    level.add(c.val);
                }

                if(c.left!=null) s.add(c.left);
                if(c.right!=null) s.add(c.right);
            }


        }

        System.out.println(level);

    }




    public static void leftView(TreeNode root){
        List<Integer> level = new ArrayList<>();
        if(root == null) { return;}
        Queue<TreeNode> s = new ArrayDeque<>();
        s.add(root);

        while(!s.isEmpty()){
            int n = s.size();

            for(int i =0;i<n;i++){
                TreeNode c = s.poll();
                if(i == 0){
                    level.add(c.val);
                }

                if(c.left!=null) s.add(c.left);
                if(c.right!=null) s.add(c.right);
            }


        }

        System.out.println(level);

    }







    public static int printTree(TreeNode root) {
        printTreeVertical(root);
        return 0;
    }
    private static void printTreeVertical(TreeNode root) {
        if (root == null) return;
        int h = depthOfTree(root);

        java.util.Queue<TreeNode> q = new java.util.LinkedList<>();
        q.add(root);

        // For each level, print nodes with calculated leading and between spacing
        for (int level = 0; level < h; level++) {
            int levelNodes = (int) Math.pow(2, level); // max nodes at this level

            // Leading spaces: 2^(h - level) - 1 (tunable)
            int leadingSpaces = (int) Math.pow(2, h - level) - 1;
            StringBuilder line = new StringBuilder();
            line.append(" ".repeat(Math.max(0, leadingSpaces)));

            for (int i = 0; i < levelNodes; i++) {
                TreeNode node = q.poll();

                if (node == null) {
                    line.append(" ");
                    // keep structure by enqueueing placeholders for next level
                    q.add(null);
                    q.add(null);
                } else {
                    String s = String.valueOf(node.val);
                    line.append(s);
                    q.add(node.left);
                    q.add(node.right);
                }

                if (i < levelNodes - 1) {
                    // Spaces between nodes on the same level
                    int betweenSpaces = (int) Math.pow(2, h - level + 1) - 1;
                    line.append(" ".repeat(Math.max(0, betweenSpaces)));
                }
            }

            // Trim trailing spaces for cleaner output and print the level
            System.out.println(line.toString().replaceAll("\\s+$", ""));
        }
    }


    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
