package com.interview;

import java.util.Arrays;

public class FootballScores {
    public static void main(String[] args) {
        FootballScores fs = new FootballScores();
        int teamA_count = 3;
        int[] teamA = {7,10,9};
        int teamB_count = 2;
        int[] teamB = {2,8};
        System.out.println(Arrays.toString(fs.counts(teamA, teamB)));
    }

    public int[] counts(int[] teamA, int[] teamB){

        int[] res = new int[teamB.length];

        quickSort(teamA, 0, teamA.length-1);

        for (int i = 0; i < teamB.length; i++) {
            res[i] = binarySearch(teamA, teamB[i])+1;
        }

        return res;
    }

    public int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]<target){
                start = mid+1;
            }else if(arr[mid]>target){
                end = mid-1;
            }else{
                return mid;
            }
        }
        return end;
    }

    public void quickSort(int[] arr, int low, int high){
        //base condition
        if(low>=high){
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end-start)/2;
        int pivot = arr[mid];
        //try to place pivot in the correct position
        while(start<=end) {
            //find the start index where element exceeds pivot
            while (arr[start] < pivot) {
                start++;
            }

            //find the end index where element is less than pivot
            while (arr[end] > pivot) {
                end--;
            }

            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        //Now pivot is at the correct index. Sort the remaining two halves
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }
}
