package com.practice.sorting;

import java.util.Arrays;

// https://leetcode.com/problems/set-mismatch/

public class SetMismatch {
    public static void main(String[] args) {
        int[] arr = {8,7,3,5,3,6,1,4};
        System.out.println(Arrays.toString(findErrorNums(arr)));
    }

    public static int[] findErrorNums(int[] nums) {
        //first apply cyclic sort since a set(which is basically a non repeated array) with range 1 to N is given
        int i = 0;
        while( i < nums.length){
            int correct = nums[i]-1;
            if(nums[i]!=nums[correct]){
                swap(nums, i, correct);
            }else{
                i++;
            }
        }
        //then loop through the array and find the element which is violating the condition element-1 == index
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]-1 != j){
                return new int[]{nums[j],j+1};
            }
        }

        return new int[]{-1, -1};
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
