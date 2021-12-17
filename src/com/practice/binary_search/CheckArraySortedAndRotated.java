package com.practice.binary_search;

public class CheckArraySortedAndRotated {
    public static void main(String[] args) {

        int[] input_array = {2, 1};
        System.out.println(check(input_array));

    }
    public static boolean check(int[] arr){
        int start = 1;
        int end = arr.length-1;
        int peaks = 0;
        while(start<=end && peaks<2){
            if(arr[start-1]>arr[start]){
                peaks++;
            }
            start++;
        }
        if(peaks==0 && arr[0]<arr[end]){
            return true;
        }
        if(peaks==1 && arr[0]>=arr[end]){
            return true;
        }
        return false;
    }
}
