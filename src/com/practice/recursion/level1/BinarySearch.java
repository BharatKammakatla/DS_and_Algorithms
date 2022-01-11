package com.practice.recursion.level1;

public class BinarySearch {
    public static void main(String[] args) {
        int[] input_array = {3, 6, 8, 9, 12, 15};
        int target = 6;
        System.out.println(search(input_array, target, 0, input_array.length-1));
    }

    static int search(int[] arr, int target, int start, int end){
        if(start>end){
            return -1;
        }
        int mid = start + (end-start)/2;
        if (arr[mid] == target){
            return mid;
        }
        if (arr[mid]>target){
            return search(arr, target, start, mid-1);
        }
        return search(arr, target, mid+1, end);
    }
}
