package com.practice.binary_search;

public class FloorOfANumber {

    public static void main(String[] args) {
        int[] input_array = {1, 3, 6, 8, 9, 12, 20};
        int target = 5;
        System.out.println(find_floor_number(input_array, target));
    }

    static int find_floor_number(int[] array, int target){
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
        if(end_index<0){
            return array[0];
        }else{
            return array[end_index];
        }

    }

}
