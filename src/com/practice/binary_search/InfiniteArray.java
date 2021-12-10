package com.practice.binary_search;

/*
* Qstn) Find the target element in a sorted array of infinite length
* */

public class InfiniteArray {
    public static void main(String[] args) {
        int[] input_array = {3, 6, 8, 9, 12, 15, 16,17, 18, 56, 63, 69, 73, 77, 81, 89, 93};
        int target = 14;
        System.out.println(searchElementInInfiniteArray(input_array, target));
    }

    static int searchElementInInfiniteArray(int[] array, int target){
        int[] range = findRange(array, target);
        int start = range[0];
        int end = range[1];
        while(start<=end){
            int mid = start + (end - start)/2;
            if(target<array[mid]){
                end = mid-2;
            }else if(target>array[mid]){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    static int[] findRange(int[] array, int target){
        int s = 0;
        int e = 0;
        int range = 1;
        boolean found = false;

        while(!found){
            if (target>array[e]){
                range = 2*range;
                s = e + 1;
                e = e + range;
            }else{
                found = true;
            }
        }
        return new int[]{s,e};
    }
}
