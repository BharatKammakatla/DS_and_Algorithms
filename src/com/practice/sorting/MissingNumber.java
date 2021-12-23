package com.practice.sorting;

// https://leetcode.com/problems/missing-number/

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 0, 2};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] nums) {
        // first do a cyclic sort
        int i = 0;
        while(i<nums.length){
            if(nums[i] == nums.length || i==nums[i]){
                i++;
            }else {
                swap(nums, i, nums[i]);
            }
        }
        //run another loop and find which element is missing
        for (int j = 0; j < nums.length; j++) {

            if(j!=nums[j]){
                return j;
            }

        }
        return nums.length;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
