package com.Target.Product.DSA;

// TC - O(n) and SC -  O(1)
public class MaxWaterContainer {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;

        while (left < right) {
            // Calculate area
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int area = h * width;

            max = Math.max(max, area);

            // Move the smaller line inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Maximum Water Stored: " + maxArea(height));
    }
}
