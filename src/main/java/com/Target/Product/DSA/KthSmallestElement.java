package com.Target.Product.DSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthSmallestElement {
	public static void main(String[] args) {
		int[] arr =  {45, 87, 54, 32, 12, 19, 76, 31, 99, 2, 3, 7, 11};
		int k = 6;
		
		findKthElemnt(arr, k);
	}
	
	public static void findKthElemnt(int[] arr, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
		//PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			maxHeap.offer(arr[i]);
			
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		
		List<Integer> list = new ArrayList<Integer>(maxHeap);
		Collections.sort(list);
		System.out.println(list);
	}
}
