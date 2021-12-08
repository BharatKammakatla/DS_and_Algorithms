package com.practice.binary_search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] input_array = {3, 6, 8, 9, 12, 15};
        int target = 15;
        System.out.println(find_element(input_array, target));

    }

    // Find the target element in an array and return its index
    // Return -1 if not found
    static int find_element(int[] array, int target){
        int start_index = 0;
        int end_index = array.length -1;

        while (start_index < end_index){
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

}
