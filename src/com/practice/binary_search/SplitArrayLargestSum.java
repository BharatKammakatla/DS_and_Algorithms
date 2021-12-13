package com.practice.binary_search;

public class SplitArrayLargestSum {

    public static void main(String[] args) {

        int[] arr = {7,2,5,10,8};
        int target = 2;
        System.out.println(splitArray(arr, target));

    }

    public static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;

        for (int i=0; i<nums.length; i++){
            start = Math.max(start, nums[i]); // in the end of the loop, this will contain the max item from the array
            end += nums[i];
        }

        // binary search
        while (start < end){
            // try for the middle as the potential answer
            int mid = start + (end-start)/2;

            // calculate how many pieces you can divide this within the max sum(mid)
            int sum = 0;
            int pieces = 1;
            for (int num: nums){
                if (sum + num > mid){
                    // you cannot add this in sub-array, make a new one
                    sum = num;
                    pieces++;
                }else{
                    sum += num;
                }
            }

            if (pieces>m){
                start = mid + 1;
            }else {
                end = mid;
            }

        }
        return end; // at this point start == end
    }
}
