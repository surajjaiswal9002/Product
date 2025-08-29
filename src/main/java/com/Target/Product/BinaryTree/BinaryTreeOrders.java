package com.Target.Product.BinaryTree;

public class BinaryTreeOrders {
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
        
        
        System.out.println(" InOrder -> left -> root -> right");
        inOrder(root);
        System.out.println();
        
        System.out.println(" preOrder -> root ->  left -> right");
        preOrder(root);
        System.out.println();
        
        System.out.println(" postOrder -> left -> right -> root");
        postOrder(root);
        System.out.println();
	}
	
	public static void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.val+" ");
		inOrder(root.left);
	}
	
	public static void preOrder(TreeNode root) {
		if(root == null) return;
		
		System.out.print(root.val+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void postOrder(TreeNode root) {
		if(root == null) return;
		
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val+" ");
	}
}
