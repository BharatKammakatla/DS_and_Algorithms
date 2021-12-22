package com.practice.sorting;

import java.util.Arrays;


public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {5, -32, 8, 0, 17};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void selectionSort(int[] arr){

        for(int i = 0; i<arr.length; i++){
            //find maximum value in the remaining array
            int max_index = 0;
            for (int j = 1; j<arr.length-i; j++){
                if (arr[j] > arr[max_index]){
                    max_index = j;
                }
            }
            //swap the last element to the end
            int temp = arr[max_index];
            arr[max_index] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }


}
