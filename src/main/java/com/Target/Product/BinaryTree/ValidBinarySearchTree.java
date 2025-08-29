package com.Target.Product.BinaryTree;

public class ValidBinarySearchTree {
	public static void main(String[] args) {
		TreeNode head = new TreeNode(5);
		head.left = new TreeNode(3);
		head.right = new TreeNode(7);
		head.left.left = new TreeNode(2);
		head.left.right = new TreeNode(4);
		head.right.right = new TreeNode(8);
		
		boolean result = isValidBST(head);
		
		System.out.println(" Is it valid Binary Search tree : "+result);
	}
	
	public static boolean isValidBST(TreeNode head) {
		return helper(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean helper(TreeNode head, int min, int max) {
		if(head == null) return false;
		
		if(head.val <= min && head.val >= max) return false;
		
		return helper(head.left, min, head.val) && helper(head.right, head.val, max);
	}
}
