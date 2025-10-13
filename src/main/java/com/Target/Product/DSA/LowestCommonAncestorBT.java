package com.Target.Product.DSA;



class TreeNode{
	int val;
	TreeNode left, right;
	
	TreeNode(int val){
		this.val = val;
		
	}
	
}

public class LowestCommonAncestorBT {
	public static void main(String[] args) {
		 // Construct Binary Tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        
        
        TreeNode p = root.left;
        TreeNode q = root.right;
        
        System.out.println( lowestCommonAncestorBT(root, p, q).val);
        
        
        
	}
	
	// O(n) and O(n)
	public static TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) {
			return root;
		}
		
		
		TreeNode left = lowestCommonAncestorBT(root.left, p, q);
		TreeNode right = lowestCommonAncestorBT(root.right, p, q);
		
		if(left != null && right != null) return root;
		
		
		return left != null ? left :right;
	}
}
