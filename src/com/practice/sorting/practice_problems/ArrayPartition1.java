package com.practice.sorting.practice_problems;

// https://leetcode.com/problems/array-partition-i/

import java.util.Arrays;

public class ArrayPartition1 {
    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        ArrayPartition1 arrayPartition1 = new ArrayPartition1();
        System.out.println(arrayPartition1.arrayPairSum(nums));
    }

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum = sum + nums[i];
        }
        return sum;
    }
}
