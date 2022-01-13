package com.practice.recursion.array_questions;

public class RotatedBinarySearch {
    public static void main(String[] args) {

        int[] arr = {5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(search(arr, 1, 0, arr.length-1));

    }

    static int search(int[] arr, int target, int start, int end){
        //base conditions
        if(start > end){
            return -1;
        }
        int mid = start + (end - start)/2;

        //check if middle element is the target
        if (arr[mid]==target){
            return mid;
        }

        //check if first half is sorted
        if(arr[start]<=arr[mid]){
            //check if target lies in this range
            if(target>=arr[start] && target<=arr[mid]){
                return search(arr, target, 0, mid-1);
            }else{
                return search(arr, target, mid+1, end);
            }
        }

        //If first half is not sorted, move to second half
        if(target>=arr[mid] && target<=arr[end]){
            return search(arr, target, mid+1, end);
        }else{
            return search(arr, target, start, mid-1);
        }
    }
}
