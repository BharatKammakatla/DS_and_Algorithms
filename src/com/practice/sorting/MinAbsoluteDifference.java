//https://leetcode.com/problems/minimum-absolute-difference/

package com.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinAbsoluteDifference {
    public static void main(String[] args) {
        int[] arr = {3,8,-10,23,19,-4,-14,27};
        System.out.println(minimumAbsDifference(arr));
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        sort(arr);
        int min_diff = arr[1]-arr[0];
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(arr[0], arr[1]));
        for (int i = 1; i < arr.length-1; i++) {
            if(arr[i+1]-arr[i] < min_diff){
                min_diff = arr[i+1]-arr[i];
                pairs.clear();
                pairs.add(Arrays.asList(arr[i], arr[i+1]));
            }else if(arr[i+1]-arr[i] == min_diff){
                pairs.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return pairs;
    }

    public static void sort(int[] arr){
        //run the steps n-1 times
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 1; j < arr.length-i; j++) {

                //swap if previous item is greater than current item
                if(arr[j]<arr[j-1]) {
                    swap(arr, j, j - 1);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
