package com.practice.binary_search;

public class SingleNonDuplicate {
    public static void main(String[] args) {
        int[] input_array = {3,3,7,7,9,10,10};
        System.out.println(singleNonDuplicate(input_array));
    }

    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid]==nums[mid-1]){
                if((mid+1)%2==0)
                    start = mid + 1;
                else
                    end = mid-2;
            }else if (nums[mid] == nums[mid+1]){
                if((nums.length-mid)%2==0)
                    end = mid - 1;
                else
                    start = mid + 2;
            }else{
                return nums[mid];
            }
        }
        return nums[start];
    }
}
