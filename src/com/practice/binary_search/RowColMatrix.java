package com.practice.binary_search;

import java.util.Arrays;

public class RowColMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {13, 34, 67, 71},
                {43, 58, 65, 88},
                {50, 60, 70, 90}
        };
        int target = 90;
        System.out.println(Arrays.toString(search(arr, target)));
    }

    public static int[] search(int[][] matrix, int target){
        int row = 0;
        int col = matrix.length - 1;
        while(row < matrix.length && col >=0){
            if(matrix[row][col]==target){
                return new int[]{row, col};
            }else if (matrix[row][col]<target){
                row++;
            }else{
                col--;
            }
        }
        return new int[]{-1,-1};
    }

}
