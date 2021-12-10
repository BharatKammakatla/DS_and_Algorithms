package com.practice.binary_search;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/

public class PeakIndexInMountain {

    public static void main(String[] args) {
        int[] input_array = {24,69,100,99,79,78,67,36,26,19};
        System.out.println(peakIndexInMountainArray(input_array));
    }

    public static int peakIndexInMountainArray(int[] arr) {

        int start = 0;
        int end = arr.length-1;

        while(start<end){
            int mid = start + (end-start)/2;
            if (arr[mid] > arr[mid+1]){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

}
