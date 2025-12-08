package com.Target.Product.Gold;

class TreeNode{
	
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val){
		this.val = val;
	}
}


public class BinaryTreeMaxPathSum {
	
	static int maxPathSum;
	
	public static void main(String[] args) {
		
		
		TreeNode node = new TreeNode(-10);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		
		
		
		System.out.println(" Binary Tree Maxium Path Sum : "+maxPathSum(node));
	}
	
	
	// tc - O(n) and sc = O(n)
	public static int maxPathSum(TreeNode node) {
		maxPathSum = Integer.MIN_VALUE;
		dfs(node);
		return maxPathSum;
	}
	
	public static int dfs(TreeNode node) {
		if(node == null) return 0;
		
		int leftGain = Math.max(0, dfs(node.left));
		int rightGain = Math.max(0, dfs(node.right));
		
		int currentPathSum = node.val + leftGain + rightGain;
		
		maxPathSum = Math.max(maxPathSum, currentPathSum);
		
		return node.val + Math.max(leftGain, rightGain);
	}
}
