package com.practice.recursion.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 3};
        selectionSort(arr, arr.length, 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr, int row, int col, int max_index) {
        //base condition
        if(row==1){
            return;
        }
        //find the maximum element
        if(col<row){
            if(arr[col]>arr[max_index]){
                max_index = col;
            }
            selectionSort(arr, row, col+1, max_index);
        }else{
            //swap the last element int the array with maxIndex
            int temp = arr[max_index];
            arr[max_index] = arr[row-1];
            arr[row-1] = temp;

            selectionSort(arr, row-1, 1, 0);
        }

    }

}
