package com.Target.Product.DSA001;

import java.util.PriorityQueue;

public class KthLargestElement {
	public static void main(String[] args) {
		int[] nums = {3,2,3,1,2,4,5,5,6};
		int k = 4;
		
		findKthLargestElement(nums, k);
	}
	
	public static void findKthLargestElement(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			minHeap.offer(nums[i]);
			
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		
		System.out.println(minHeap.peek());
	}
	
	
}
