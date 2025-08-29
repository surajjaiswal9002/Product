package com.Target.Product.BinaryTree;

import com.Target.Product.gspdfproble.Node;

public class LargestSumSubTreeBinaryTree {
    public static void main(String[] args) {

        TreeNode head = new TreeNode(10);
        head.left = new TreeNode(8);
        head.right = new TreeNode(2);
        head.left.left = new TreeNode(5);
        head.left.right = new TreeNode(3);

        int ans = findSumOfSubTreeBT(head);

        System.out.println(ans);
    }

    public static int findSumOfSubTreeBT(TreeNode head) {
        if (head == null) return 0;

        int[] ans = new int[1];

        findSubTreeSum(head, ans);

        return ans[0];
    }

    public static int findSubTreeSum(TreeNode head, int[] ans) {
        if (head == null) {
            return 0;
        }

        int currSum = head.val + findSubTreeSum(head.left, ans) + findSubTreeSum(head.right, ans);
        ans[0] = Math.max(currSum, ans[0]);

        return currSum;
    }


}
