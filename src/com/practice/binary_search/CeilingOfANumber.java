package com.practice.binary_search;

public class CeilingOfANumber {
    public static void main(String[] args) {
        int[] input_array = {1, 3, 6, 8, 9, 12, 20};
        int target = 10;
        System.out.println(find_ceiling_number(input_array, target));
    }
    // return the smallest number >= target
    static int find_ceiling_number(int[] array, int target){

        // What if the target is greater than the largest number
        if(target > array[array.length-1])
            return array[array.length-1];

        int start_index = 0;
        int end_index = array.length -1;

        while(start_index<=end_index){
            int mid_index = start_index + (end_index-start_index)/2;
            if (target > array[mid_index]){
                start_index = mid_index + 1;
            }else if (target < array[mid_index]){
                end_index = mid_index - 1;
            }else{
                return array[mid_index];
            }
        }
        return array[start_index];
    }
}
