package com.practice.sorting.practice_problems;

// https://leetcode.com/problems/sort-array-by-parity-ii/

import java.util.Arrays;

public class SortArrayByParity2 {
    public static void main(String[] args) {
        int[] nums = {648,831,560,986,192,424,997,829,897,843};
        SortArrayByParity2 sortArrayByParity2 = new SortArrayByParity2();
        System.out.println(Arrays.toString(sortArrayByParity2.sortArrayByParityII(nums)));
    }

    public int[] sortArrayByParityII(int[] nums) {

        int i = 0;
        int j = 1;
        int n = nums.length;

        while(i<n && j<n){
            while (i<n && nums[i]%2==0){
                i+=2;
            }
            while (j<n && nums[j]%2==1){
                j+=2;
            }

            if(i<n && j<n){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i+=2;
                j+=2;
            }
        }
        return nums;
    }
}
