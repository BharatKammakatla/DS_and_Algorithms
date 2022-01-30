package com.practice.sorting.practice_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RelativeSortArray {
    public static void main(String[] args) {
        RelativeSortArray rsv = new RelativeSortArray();
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(rsv.relativeSortArray2(arr1, arr2)));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> hm = new TreeMap<>();
        for (int num : arr1) {
            if(hm.get(num)==null){
                hm.put(num, 1);
            }else{
                hm.put(num, hm.get(num)+1);
            }
        }

        int k = 0;
        for (int num : arr2) {
            int count = hm.get(num);
            while(count>0){
                arr1[k] = num;
                k++;
                count--;
            }
            hm.remove(num);
        }

        for (Map.Entry<Integer, Integer> entry: hm.entrySet()) {
            int count = entry.getValue();
            while(count>0){
                arr1[k] = entry.getKey();
                k++;
                count--;
            }
        }

        return arr1;

    }

    //Efficient Method
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {

        // Bucket for 0 <= arr element <= 1000
        int[] bucket = new int[1001];

        int[] result = new int[arr1.length];
        int index = 0;

        //Fill the bucket
        for (int i : arr1) {
            bucket[i]++;
        }

        //First store the results in order of arr 2
        for (int i : arr2) {
            while(bucket[i] > 0){
                result[index] = i;
                index++;
                bucket[i]--;
            }
        }

        //Fill the remaining elements
        for (int i = 0; i < 1001; i++) {
            if(bucket[i]>0){
                while(bucket[i] > 0){
                    result[index] = i;
                    index++;
                    bucket[i]--;
                }
            }
        }

        return result;
    }
}
