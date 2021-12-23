package com.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(arr));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        // first sort the array using cyclic sort
        int i = 0;
        while (i < nums.length){
            int correct = nums[i] - 1;

            if(nums[i]!=nums[correct]){
                swap(nums, i, correct);
            }else{
                i++;
            }

        }

        // loop through all the elements and find all missing elements
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]-1 != j){
                res.add(j+1);
            }
        }
        return res;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
