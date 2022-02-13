package com.practice.recursion.practice_problems;

// https://www.geeksforgeeks.org/recursive-programs-to-find-minimum-and-maximum-elements-of-array/

import java.util.Arrays;

public class MinimumAndMaximumInArray {
    public static void main(String[] args) {
        MinimumAndMaximumInArray minmax = new MinimumAndMaximumInArray();
        int[] arr = {1, 4, 45, 6, 10, -8};
        System.out.println(Arrays.toString(minmax.findMinMax(arr, 0, arr[0], arr[0])));
    }

    public int[] findMinMax(int[] arr, int index, int min, int max){

        //base condition
        if(index == arr.length){
            return new int[]{min, max};
        }

        if(arr[index] < min){
            return findMinMax(arr, index+1, arr[index], max);
        }else if(arr[index] > max){
            return findMinMax(arr, index+1, min, arr[index]);
        }

        return findMinMax(arr, index+1, min, max);

    }
}
