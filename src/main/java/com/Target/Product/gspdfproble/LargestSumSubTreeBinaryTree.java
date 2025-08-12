package com.Target.Product.gspdfproble;

public class LargestSumSubTreeBinaryTree {
    public static void main(String[] args) {

        Node head = new Node(10);
        head.left = new Node(8);
        head.right = new Node(2);
        head.left.left = new Node(5);
        head.left.right = new Node(3);

        int ans = findSumOfSubTreeBT(head);

        System.out.println(ans);
    }

    public static int findSumOfSubTreeBT(Node head) {
        if (head == null) return 0;

        int[] ans = new int[1];

        findSubTreeSum(head, ans);

        return ans[0];
    }

    public static int findSubTreeSum(Node head, int[] ans) {
        if (head == null) {
            return 0;
        }

        int currSum = head.data + findSubTreeSum(head.left, ans) + findSubTreeSum(head.right, ans);
        ans[0] = Math.max(currSum, ans[0]);

        return currSum;
    }


}
