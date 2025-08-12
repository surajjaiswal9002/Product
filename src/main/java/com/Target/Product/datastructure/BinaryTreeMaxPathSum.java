package com.Target.Product.datastructure;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


public class BinaryTreeMaxPathSum {
    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        int ans = maxPathSum(node);
        System.out.println(ans);
    }

    public static int maxPathSum(TreeNode root) {
        int[] diameter = new int[1];
        diameter[0] = 1;
        maxGain(root, diameter);
        return diameter[0];
    }

    public static int maxGain(TreeNode root, int[] diameter) {
        if (root == null) return 0;

        int left = Math.max(0, maxGain(root.left, diameter));
        int right = Math.max(0, maxGain(root.right, diameter));


        diameter[0] = Math.max(diameter[0], (left + right + root.val));

        return root.val + Math.max(left, right);
    }
}
