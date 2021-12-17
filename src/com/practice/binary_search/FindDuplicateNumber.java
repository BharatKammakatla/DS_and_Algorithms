package com.practice.binary_search;

// https://leetcode.com/problems/find-the-duplicate-number/

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,2,7,5,6,6,4};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length;
        int count;

        //find the sum of the elements in an array
        while(start<=end){
            int mid = start + (end-start)/2;
            count = 0;
            for (int num: nums){
                if (num <= mid)
                    count++;
            }
            if(count<=mid){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
}
