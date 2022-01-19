package com.practice.recursion.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {

        int[] arr = {5, 8, 7, 1, 6, 2};
//        arr = mergeSort(arr);
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    static int[] mergeSort(int[] arr){
        //base condition
        if(arr.length == 1){
            return arr;
        }
        //Divide array into two parts
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second){
        int[] mergedArray = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mergedArray[k] = first[i];
                i++;
            }else{
                mergedArray[k] = second[j];
                j++;
            }
            k++;
        }

        //It may be possible that one of the arrays is not complete.
        //If so, copy the remaining elements
        while(i<first.length){
            mergedArray[k]=first[i];
            i++;
            k++;
        }
        while(j<second.length){
            mergedArray[k]=second[j];
            j++;
            k++;
        }

        return mergedArray;
    }


    static void mergeSortInPlace(int[] arr, int start, int end){
        //base condition
        if(end - start == 1){
            return;
        }
        //Divide array into two parts
        int mid = start + (end - start)/2;
        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end){
        int[] mergedArray = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while(i<mid && j<end){
            if(arr[i]<arr[j]){
                mergedArray[k] = arr[i];
                i++;
            }else{
                mergedArray[k] = arr[j];
                j++;
            }
            k++;
        }

        //It may be possible that one of the arrays is not complete.
        //If so, copy the remaining elements
        while(i<mid){
            mergedArray[k]=arr[i];
            i++;
            k++;
        }
        while(j<end){
            mergedArray[k]=arr[j];
            j++;
            k++;
        }

        //Replace in the original array
        for(int l = 0; l < mergedArray.length; l++) {
            arr[start+l] = mergedArray[l];
        }

    }
}
