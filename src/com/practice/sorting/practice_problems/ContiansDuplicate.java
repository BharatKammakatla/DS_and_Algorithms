package com.practice.sorting.practice_problems;

// https://leetcode.com/problems/contains-duplicate/

import java.util.ArrayList;
import java.util.HashMap;

public class ContiansDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2};
        System.out.println(containsDuplicate2(nums));
    }

    // Method 1
    public static boolean containsDuplicate(int[] nums) {
        //Sort the array using quick sort
        quicksort(nums, 0, nums.length-1);

        //Loop through the array and find duplicates
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]){
                return true;
            }
        }
        return false;
    }

    public static void quicksort(int[] nums, int low, int high) {
        //base condition
        if(low>=high){
            return;
        }

        int s = low;
        int e = high;
        int pivot = nums[s+(e-s)/2];

        //Try to place pivot at correct position
        while(s<=e){
            //Find the value where start index voilates(i.e. when nums[s]>=pivot)
            while(nums[s]<pivot){
                s++;
            }
            //Find the value where end index voilates(i.e. when nums[e]<=pivot)
            while(nums[e]>pivot){
                e--;
            }
            //Swap start and end indices which are violating
            if(s<=e){
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }

        //Now since the pivot is placed at correct position. Repeat the same process for
        //array subsets on either side of the pivot
        quicksort(nums,low,e);
        quicksort(nums,s,high);
    }


    //Method 2
    public static boolean containsDuplicate2(int[] nums) {
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int num : nums) {
            if(hm.get(num) == null){
                hm.put(num, true);
            }else{
                return true;
            }
        }
        return false;
    }
}
