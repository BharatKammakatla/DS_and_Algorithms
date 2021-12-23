package com.practice.sorting;

import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {7,8,9,11,12};
        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums) {
        /*to find the smallest missing positive, if the array is sorted we can just run one for loop and find it.
        So we will sort it. The best algo to sort is Cyclic sort with O(n) complexity.*/
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i]>0 && nums[i]<nums.length && nums[i]!=nums[correct]){
                swap(nums, i, correct);
            }else{
                i++;
            }
        }

        //Loop through the array and find the element which is mismatching with its index
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=j+1){
                return j+1;
            }
        }
        return nums.length+1;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
