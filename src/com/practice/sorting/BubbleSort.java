package com.practice.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        //run the steps n-1 times
        for (int i=0; i<arr.length; i++){
            // After end of each step, maximum item will be moved to its last respective index
            boolean swapped = false;

            for(int j=1; j<arr.length-i; j++){
                // swap if the element is smaller than the previous element
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }

            }

            //break the loop if the elements are not swapped atleast once
            if(!swapped){
                break;
            }

        }
    }

}
