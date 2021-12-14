package com.practice.binary_search;

public class KthMissingPostitiveNumber {
    public static void main(String[] args) {
        int[] input_array = {2};
        int target = 5;
        System.out.println(findKthPositive(input_array, target));
    }

    public static int findKthPositive(int[] arr, int k) {
        int start =0;
        int end = arr.length - 1;

        while(start<=end){
            int mid = start + (end-start)/2;
            int diff = arr[mid]-(mid+1);
            if(diff<k){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        if (end == -1){
            return k;
        }
        return arr[end] + k - (arr[end]-(end+1));
    }
}
