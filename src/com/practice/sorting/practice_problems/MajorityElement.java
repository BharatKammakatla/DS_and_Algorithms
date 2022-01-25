package com.practice.sorting.practice_problems;

//https://leetcode.com/problems/majority-element/

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement2(nums));
    }

    public static int majorityElement(int[] nums) {
        //Sort the array with quick sort
        quickSort(nums, 0, nums.length-1);

        int maxReps = 1;
        int maxIndex = 0;
        int reps = 1;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){
                reps++;
                if(i == nums.length-1 && reps>maxReps){
                    maxReps = reps;
                    maxIndex = nums.length-1;
                }
            }else{
                if(reps>maxReps){
                    maxReps = reps;
                    maxIndex = i-1;
                }reps = 1;
            }
        }

        return nums[maxIndex];

    }

    public static void quickSort(int[] arr, int low, int high){
        //base condition
        if(low>=high){
            return;
        }

        int s = low;
        int e = high;
        int pivot = arr[s + (e-s)/2];

        // Place the pivot at correct position
        while(s<=e){
            //check where start index violates
            while(arr[s]<pivot){
                s++;
            }
            //check where end index violates
            while(arr[e]>pivot){
                e--;
            }

            //swap start and end indices
            if(s<=e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        //Now pivot is at correct position. Apply quick sort on sub-arrays on either sides of the pivot
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }


    //Method 2

    public static int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int number: nums) {
            if(hm.get(number) == null){
                hm.put(number, 1);
            }else{
                hm.put(number, hm.get(number)+1);
            }
        }
        //Get the key having max value in hashmap
        Map.Entry<Integer, Integer> maxEntry = null;

        for (Map.Entry<Integer, Integer> entry : hm.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();
    }

}
