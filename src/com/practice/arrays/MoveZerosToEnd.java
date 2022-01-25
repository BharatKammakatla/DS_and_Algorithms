package com.practice.arrays;

//https://leetcode.com/problems/move-zeroes/

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    // Move zeros to end with maintaining the relative order of the non zero elements
    public static void moveZeroes(int[] nums) {

        int start = 0;
        int k = 0;

        while(start<nums.length){
            if(nums[start]!=0){
                nums[k] = nums[start];
                start++;
                k++;
            }else{
                start++;
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }

    }





    // Move zeros to end without maintaining the relative order of the non zero elements
    public static void moveZeroes1(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            while(nums[start]!=0){
                start++;
            }
            while(nums[end]==0){
                end--;
            }
            if(start<end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
}
