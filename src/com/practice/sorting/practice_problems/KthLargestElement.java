package com.practice.sorting.practice_problems;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        KthLargestElement kle = new KthLargestElement();
        System.out.println(kle.findKthLargest(nums, 2));
    }
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, nums.length-k+1);
    }

    private int quickSelect(int[] nums, int low, int high, int k_index) {

        //find the partition
        int pivot_index = partition(nums, low, high);

        //3 cases
        if(pivot_index == k_index-1){
            return nums[pivot_index];
        }else if(pivot_index < k_index-1){
            return quickSelect(nums, pivot_index+1, high, k_index);
        }else{
            return quickSelect(nums, low, pivot_index-1, k_index);
        }

    }

    private int partition(int[] arr, int low, int high){
        int pivot_location = low;
        int pivot = arr[high];
        for (int i = low; i <=high ; i++) {
            if(arr[i]<pivot){
                int temp = arr[i];
                arr[i] = arr[pivot_location];
                arr[pivot_location] = temp;
                pivot_location++;
            }
        }
        //swapping pivot with the final pivot location
        int temp = arr[high];
        arr[high] = arr[pivot_location];
        arr[pivot_location] = temp;

        return pivot_location;
    }

}
