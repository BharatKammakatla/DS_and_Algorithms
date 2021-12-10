package com.practice.binary_search;

//https://leetcode.com/problems/find-in-mountain-array/

public class FindInMountain {

    public static void main(String[] args) {

        int[] input_array = {1,2,3,4,5,3,1};
        int target = 3;
        System.out.println(findInMountainArray(input_array, target));

    }

    public static int findInMountainArray(int[] arr, int target) {

        int peak = peakIndexInMountainArray(arr);
        int res_index = binary_search_oa(arr, target, 0, peak);
        if(res_index!=-1){
            return res_index;
        }
        //else try to search in second half
        return binary_search_oa(arr, target,peak+1, arr.length-1);

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

    // Find the target element in an array and return its index
    // Return -1 if not found
    static int binary_search_oa(int[] array, int target, int start_index, int end_index){
        // find whether array is sorted in ascending or descending order
        boolean isAsc = array[start_index] < array[end_index];

        while (start_index <= end_index){
            int middle_index = (start_index+end_index)/2;

            if (target == array[middle_index]){
                return middle_index;
            }
            if (isAsc){
                if (target < array[middle_index]){
                    end_index = middle_index -1;
                }else{
                    start_index = middle_index + 1;
                }
            }else{
                if (target > array[middle_index]){
                    end_index = middle_index -1;
                }else{
                    start_index = middle_index + 1;
                }
            }

        }

        return -1;
    }

}
