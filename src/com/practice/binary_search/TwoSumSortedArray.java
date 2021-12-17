package com.practice.binary_search;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumSortedArray {
    public static void main(String[] args) {
        int[] input_array = {2,7,11,15};
        int target = 17;
        System.out.println(Arrays.toString(twoSum(input_array, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        while(start<end){
            int sum = numbers[end]+numbers[start];
            if(sum>target){
                end--;
            }else if(sum<target){
                start++;
            }else{
                return new int[]{start+1, end+1};
            }
        }
        return new int[2];
    }

}
