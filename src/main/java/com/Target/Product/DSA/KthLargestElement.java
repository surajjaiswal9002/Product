package com.Target.Product.DSA;

import java.sql.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
	public static void main(String[] args) {
		//int[] nums = {3,2,1,5,6,4};
		
		//int k = 2;
		
		int[] nums = {3,2,3,1,2,4,5,5,6};
		int k = 4;
		
		findKthLargestElement(nums, k);
		findKthLargestElementUsingInbuildFun(nums, k);
	}
	
	
	
	// Tc - O(n log n) and sc - o(k)
	public static void findKthLargestElement(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			minHeap.offer(nums[i]);
			
			if(minHeap.size()  > k) {
				minHeap.poll();
			}
		}
		
		System.out.println(minHeap.peek());
	}
	
	// Tc - O(n log n) and sc - o(1)
	public static void findKthLargestElementUsingInbuildFun(int[] nums, int k) {
		Arrays.sort(nums);
		
		System.out.println(nums[nums.length - k]);
	}
}
