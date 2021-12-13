package com.practice.binary_search;
//https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] input_array = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(input_array, target));
    }

    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (pivot==-1){
            // it means array is not rotated and hence we can do a normal binary search
            return binary_search(nums, target, 0, nums.length - 1);
        }
        if(nums[pivot] == target){
            return pivot;
        }
        if(target >= nums[0]) {
            return binary_search(nums, target, 0, pivot - 1);
        }
        return binary_search(nums, target, pivot+1, nums.length-1);

    }

    // Find the target element in an array and return its index
    // Return -1 if not found
    static int binary_search(int[] array, int target, int start_index, int end_index){

        while (start_index <= end_index){
            int middle_index = (start_index+end_index)/2;
            if (target < array[middle_index]){
                end_index = middle_index -1;
            }else if (target > array[middle_index]){
                start_index = middle_index + 1;
            }else{
                return middle_index;
            }
        }

        return -1;
    }

    public static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start<=end){
            int mid = start + (end - start)/2;
            // 4 cases
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid-1]){
                return mid - 1;
            }
            if(arr[mid] <= arr[start]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return -1;
    }


    public static int findPivotWithDuplicates(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start<=end){
            int mid = start + (end - start)/2;
            // cases
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid-1]){
                return mid - 1;
            }
            //if elements at middle, start, end are equal then skip the duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                //skip the duplicates
                //Note: What if start and end are pivots ?
                // check if start is pivot
                if(arr[start]>arr[start+1]){
                    return start;
                }
                start++;
                // check if end is pivot
                if(arr[end] < arr[end-1]){
                    return end - 1;
                }
                end--;
            }
            // left is sorted, so pivot should be in right
            else if(arr[start]<arr[mid] || (arr[start]==arr[mid] && arr[mid]>arr[end])){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return -1;
    }
}
