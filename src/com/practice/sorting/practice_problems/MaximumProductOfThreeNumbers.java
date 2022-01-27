package com.practice.sorting.practice_problems;

// https://leetcode.com/problems/maximum-product-of-three-numbers/

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        int[] nums = {1,2,4,6};
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int a = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        int b = nums[0]*nums[1]*nums[nums.length-1];
        return a>b ? a : b ;
    }
}
