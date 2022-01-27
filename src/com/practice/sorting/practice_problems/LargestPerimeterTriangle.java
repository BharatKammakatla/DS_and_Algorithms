package com.practice.sorting.practice_problems;

// https://leetcode.com/problems/largest-perimeter-triangle/

import java.util.Arrays;

public class LargestPerimeterTriangle {
    public static void main(String[] args) {
        int[] nums = {2,1,2};
        LargestPerimeterTriangle largestPerimeterTriangle = new LargestPerimeterTriangle();
        System.out.println(largestPerimeterTriangle.largestPerimeter(nums));
    }

    // For a >= b >= c, a,b,c can form a triangle if a < b + c.
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = n-1; i >1 ; --i) {
            if(nums[i]<(nums[i-1]+nums[i-2])){
                return nums[i]+nums[i-1]+nums[i-2];
            }
        }
        return 0;
    }

}
