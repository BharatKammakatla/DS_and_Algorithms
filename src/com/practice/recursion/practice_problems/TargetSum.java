package com.practice.recursion.practice_problems;

public class TargetSum {
    public static void main(String[] args) {
        TargetSum ts = new TargetSum();
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(ts.findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {

        return findCount(nums, 0, target, 0, 0);

    }

    public int findCount(int[] arr, int index, int target, int sum){

        //base condition
        if(index == arr.length && sum == target){
            return 1;
        }

        if(index == arr.length){
            return 0;
        }

        int leftSum = sum + arr[index];
        int rightSum = sum - arr[index];



        return count;
    }
}
