package com.practice.sorting.practice_problems;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        SquaresOfSortedArray obj = new SquaresOfSortedArray();
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(obj.sortedSquares2(nums)));
    }
    public int[] sortedSquares1(int[] nums) {
        //BS to find pivot(Zero or smallest positive number)
        int pivot = findPivotIndex(nums);

        int[] mergedArray = new int[nums.length];
        int k = 0;

        if (pivot==-1){
            for (int i = nums.length-1; i >=0 ; i--) {
                mergedArray[k]=nums[i]*nums[i];
                k++;
            }
            return mergedArray;
        }

        //merge sorted arrays
        //arr1 range i till pivot-1
        //arr2 range pivot till nums.length-1
        int i = pivot -1;
        int j = pivot;


        while(i>=0 && j<nums.length){
            if((-1*nums[i]) < nums[j]){
                mergedArray[k]=nums[i]*nums[i];
                i--;
            }else{
                mergedArray[k]=nums[j]*nums[j];
                j++;
            }
            k++;
        }

        //Fill the left out array
        while(i>=0){
            mergedArray[k]=nums[i]*nums[i];
            i--;
            k++;
        }
        while(j<nums.length){
            mergedArray[k]=nums[j]*nums[j];
            j++;
            k++;
        }

        return mergedArray;
    }

    public int findPivotIndex(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start + (end - start)/2;

            if(0 < arr[mid]){
                end = mid-1;
            }else if(0 > arr[mid]){
                start = mid+1;
            }else{
                return mid;
            }
        }
        if (start > arr.length-1){
            return -1;
        }else {
            return start;
        }
    }

    // Efficient Method
    public int[] sortedSquares2(int[] nums){
        int i = 0;
        int j = nums.length-1;
        int k = nums.length-1;
        int[] resArray = new int[nums.length];

        while(i<=j){
            if(Math.abs(nums[i])>Math.abs(nums[j])){
                resArray[k]=nums[i]*nums[i];
                i++;
            }else{
                resArray[k]=nums[j]*nums[j];
                j--;
            }
            k--;
        }
        return resArray;
    }
}
