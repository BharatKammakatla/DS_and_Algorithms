package com.practice.recursion.sorting;

public class QuickSelect {
    public static void main(String[] args) {
        QuickSelect qs= new QuickSelect();
        int[] nums = {3,2,1,5,6,4};
        //quick select is used for finding the kth smallest/largest element in an unodered array.
        //Find the kth smallest element
        System.out.println(qs.quickSelect(nums, 0, nums.length-1, 1));

    }

    public int quickSelect(int[] nums, int low, int high , int k){

        //use quicksort's idea
        //Put the numbers that are <= to pivot to its left
        //Put numbers that are > pivot to its right
        int start = low;
        int pivot = low;
        while(start<high){
            if(nums[start]<=nums[high]){
                swap(nums, start, pivot);
                pivot++;
            }
            start++;
        }
        //swap the final position of pivot with nums[end]
        swap(nums, pivot, high);

        if (pivot == k-1) {
            return nums[pivot];
        }else if (pivot > k-1){
            return quickSelect(nums, low, pivot-1, k);
        }else{
            return quickSelect(nums, pivot+1, high, k);
        }
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
