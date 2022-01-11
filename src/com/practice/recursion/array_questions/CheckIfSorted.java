package com.practice.recursion.array_questions;

public class CheckIfSorted {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        System.out.println(checkIfSorted(arr, 0));
    }
    static boolean checkIfSorted(int[] arr, int index){
        //base condition
        if(index == arr.length-1){
            return true;
        }
        return arr[index] <= arr[index+1] && checkIfSorted(arr, index+1);
    }
}
