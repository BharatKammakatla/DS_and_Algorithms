package com.practice.recursion.practice_problems;

//https://www.geeksforgeeks.org/sum-triangle-from-array/#

import java.util.Arrays;

public class SumTriangleFromArray {
    public static void main(String[] args) {
        SumTriangleFromArray sta = new SumTriangleFromArray();
        int[] arr = {1, 2, 3, 4, 5};
        sta.printSumTriangle(arr);
    }

    public void printSumTriangle(int[] array){

        if(array.length == 1){
            System.out.println(Arrays.toString(array));
            return;
        }

        int[] tempArray = new int[array.length -1];
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = array[i] + array[i+1];
        }
        printSumTriangle(tempArray);
        System.out.println(Arrays.toString(array));
    }
}
