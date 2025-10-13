package com.Target.Product;


		public class TripletSum {
			   // Sum - Triplet Sum in Array
			   // Input: arr[] = [1, 1, 0, 6, 11, 8], target = 13
			   //Output: true
			   //Explanation: The triplet [1, 4, 8] sums up to 13
			 
			        // Function to check if there exists a triplet with the given sum
			       public static boolean hasTripletSum(int[] arr, int target) {
			        		
			        	int n = arr.length;
			        	
			        	for(int i = 0; i < n; i++) {
			        		int low = i + 1;
			        		int high = n - 1;
			        		
			        		while(low < high) {
			        			int curr = arr[i] + arr[low] + arr[high];
			        			
			        			if(curr == target) {
			        				return true;
			        			}else if(curr < target) {
			        				low++;
			        			}else {
			        				high--;
			        			}
			        		}
			        	}
			        	
			        	return false;
			        }
			 
			        public static void main(String[] args) {
			          //  int[] arr = { 1, 4, 45, 6, 10, 8 };
			          //  int target = 13;
			        	int[] arr = {0,0,0,0,0};
			        	int target = 2;
			 
			            if (hasTripletSum(arr, target))
			                System.out.println("true");
			            else
			                System.out.println("false");
			        }
			    }
