package com.practice.sorting.practice_problems;

// https://leetcode.com/problems/assign-cookies/

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {};
        System.out.println(findContentChildren(g,s));
    }

    public static int findContentChildren(int[] g, int[] s) {

        //sort the arrays
//        mergeSort(g, 0, g.length);
//        mergeSort(s, 0, s.length);
        Arrays.sort(g);
        Arrays.sort(s);


        int i = 0;
        int j = 0;

        while(i<g.length && j<s.length){
            if(s[j]>=g[i]){
                i++;
                j++;
            }else{
                j++;
            }
        }

        return i;
    }

    public static void mergeSort(int[] arr, int start, int end){
        //base condition
        if((end - start) <= 1){
            return;
        }

        int mid = start + (end-start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);

        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] mergedArray = new int[end-start];

        int i = start;
        int j = mid;
        int k = 0;

        while(i<mid && j<end){
            if(arr[i] < arr[j]){
                mergedArray[k]=arr[i];
                i++;
            }else{
                mergedArray[k]=arr[j];
                j++;
            }
            k++;
        }

        // It may be possible that one of the arrays is not complete.
        // If so, fill the remaining array
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
        for (int l = 0; l < mergedArray.length; l++) {
            arr[start+l] = mergedArray[l];
        }

    }

}
