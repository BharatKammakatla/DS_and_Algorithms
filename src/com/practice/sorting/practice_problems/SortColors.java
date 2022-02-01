package com.practice.sorting.practice_problems;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] nums = {2,0,2,1,1,0};
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    public void quickSort(int[] nums, int low, int high) {
        //base condition
        if(low>=high){
            return;
        }
        int start = low;
        int end = high;
        int pivot = nums[start + (end-start)/2];
        //try to place pivot in correct position
        while(start<=end){
            //find where start index violates
            while(nums[start]<pivot){
                start++;
            }
            //find where end index violates
            while(nums[end]>pivot){
                end--;
            }
            //swap the indices to eliminate violations
            if(start<=end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        //Now pivot is in correct position.
        //Apply the same sort to left and right sub arrays
        quickSort(nums, low, end);
        quickSort(nums, start, high);
    }
}
