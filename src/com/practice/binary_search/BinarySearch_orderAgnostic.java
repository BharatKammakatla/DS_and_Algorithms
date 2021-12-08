package com.practice.binary_search;

public class BinarySearch_orderAgnostic {

    public static void main(String[] args) {
        int[] input_array = {3, 6, 8, 9, 12, 20};
        int target = 20;
        System.out.println(find_element(input_array, target));

    }

    // Find the target element in an array and return its index
    // Return -1 if not found
    static int find_element(int[] array, int target){
        int start_index = 0;
        int end_index = array.length -1;

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
