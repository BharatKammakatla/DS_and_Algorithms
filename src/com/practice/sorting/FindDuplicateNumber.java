package com.practice.sorting;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {

        // sort the array using cyclic sort
        int i = 0;
        while(i < nums.length){

            if (nums[i] != i+1){
                int correct = nums[i] - 1;
                if(nums[i] != nums[correct]){
                    swap(nums, i, correct);
                }else{
                    return nums[i];
                }
            }else{
                i++;
            }

        }

//        //just run one for loop and break when u find a repeated number
//        for (int j = 0; j < nums.length-1; j++) {
//            if(nums[j]-1 != j){
//                return nums[j];
//            }
//        }
        return -1;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
