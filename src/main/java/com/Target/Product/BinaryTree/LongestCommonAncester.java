package com.Target.Product.BinaryTree;

public class LongestCommonAncester {
    public static void main(String[] args) {
        
        // Build tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // ✅ Option 1: use actual references
        TreeNode p = root.left;    // Node 5
        TreeNode q = root.right;   // Node 1
        TreeNode ancestor = findLCA(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + ancestor.val);

        // ✅ Option 2: if you only know values, find nodes first
        TreeNode p2 = findNode(root, 5);
        TreeNode q2 = findNode(root, 4);
        TreeNode ancestor2 = findLCA(root, p2, q2);
        System.out.println("LCA of " + p2.val + " and " + q2.val + " is: " + ancestor2.val);
    }

    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    // Helper method to fetch nodes by value
    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode left = findNode(root.left, val);
        if (left != null) return left;
        return findNode(root.right, val);
    }
}