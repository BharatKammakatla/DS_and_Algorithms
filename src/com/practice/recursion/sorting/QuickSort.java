package com.practice.recursion.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 8, 7, 1, 6, 2};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high){
        //base condition
        if(low >= high){
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end-start)/2;

        int pivot = arr[mid];

        //Trying to place the pivot at correct position
        while(start<=end){
            //check where start index voilates
            while(arr[start]<pivot){
                start++;
            }
            //check where end index voilates
            while(arr[end]>pivot){
                end--;
            }

            //swap the start & end to eliminate voilations
            if(start<=end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        //Now pivot is at correct index. so sort the remaining two halves
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }
}
