package com.Target.Product.DSA.Test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.Target.Product.DSA.TwoSum;

public class TwoSumTest {
	
	@Test
	void testValidCases() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] expected = {0, 1};
		
		assertArrayEquals(expected, TwoSum.isTwoSum(nums, target));
	}
}
