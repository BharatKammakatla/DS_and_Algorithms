package com.practice.sorting;

/*
(****) When given numbers form range 1 to N, use cyclic sort.
 */

import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {
        int[] arr = {-1, 1, 4, -1};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void cyclicSort(int[] arr){
        int i = 0;
        while(i< arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr, i, correct);
            }else{
                i++;
            }
        }
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
