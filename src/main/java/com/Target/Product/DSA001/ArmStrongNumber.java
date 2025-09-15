package com.Target.Product.DSA001;

public class ArmStrongNumber {
	public static void main(String[] args) {
		int n = 153;
		
		findArmStrongNumber(n);
	}
	
	public static void findArmStrongNumber(int n) {
		
		int temp = n;
		int len = String.valueOf(n).length();
		int armStrongNum = 0;
		
		while(n != 0) {
			int rem  = n % 10;
			armStrongNum = armStrongNum + (int) Math.pow(rem, len);
			n = n / 10;
		}
		
		if(armStrongNum == temp) {
			System.out.println(" ArmStrong Number ");
		}else {
			System.out.println("Not an ArmStrong Number ");
		}
	}
}
