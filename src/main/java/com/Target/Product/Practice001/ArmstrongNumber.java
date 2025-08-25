package com.Target.Product.Practice001;

public class ArmstrongNumber {
	public static void main(String[] args) {
		
		int n = 153;
		
		int armNum = 0;
		int len = String.valueOf(n).length();
		int temp = n;
		
		while(n != 0) {
			int rem = n % 10;
			armNum = (int) (armNum + Math.pow(rem, len));
			n = n / 10;
		}
		
		
		if(temp == armNum) {
			System.out.println(" Armstrong Number : "+armNum);
			return;
		}
		
		
		System.out.println(" No a Armstrong Number : "+armNum);
		
	}
}
