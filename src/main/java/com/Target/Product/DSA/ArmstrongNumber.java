package com.Target.Product.DSA;

public class ArmstrongNumber {
	public static void main(String[] args) {

		int n = 153;

		isArmstrongNum(n);
	}

	// Tc - O(n) and sc - O(1)
	public static void isArmstrongNum(int n) {

		int temp = n;
		int len = String.valueOf(n).length();
		int num = 0;

		while (n != 0) {
			int rem = n % 10;
			num = (int) (num + Math.pow(rem, len));
			n = n / 10;
		}

		if (temp == num) {
			System.out.println(num + " is a  ArmStrongNumber");
		} else {
			System.out.println(temp + " is not a ArmStrongNumber");
		}
	}
}
