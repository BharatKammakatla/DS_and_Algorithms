package com.practice.sorting.practice_problems;

public class HeightChecker {
    public static void main(String[] args) {
        HeightChecker hc = new HeightChecker();
        int[] heights = {1,1,4,2,1,3};
        System.out.println(hc.heightChecker(heights));
    }


    public int heightChecker(int[] heights) {
        int[] heightsCopy = heights.clone();
        quickSort(heights, 0, heights.length-1);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i]!=heightsCopy[i]){
                count++;
            }
        }
        return count;
    }

    private void mergeSort(int[] arr, int start, int end) {
        //base condition
        if (end-start == 1){
            return;
        }
        int mid = start + (end-start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid;
        int k = 0;
        int[] res = new int[end-start];
        while(i<mid && j<end){
            if(arr[i]<arr[j]){
                res[k] = arr[i];
                i++;
            }else{
                res[k] = arr[j];
                j++;
            }
            k++;
        }
        //fill the left over array
        while(i<mid){
            res[k]=arr[i];
            i++;
            k++;
        }
        while(j<end){
            res[k]=arr[j];
            j++;
            k++;
        }
        //replace res array with original array
        for (int l = 0; l < res.length; l++) {
            arr[start+l] = res[l];
        }
    }

    private void quickSort(int[] arr, int low, int high){
        //base condition
        if(low>=high){
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end-start)/2;
        int pivot = arr[mid];

        //Try to place the pivot in correct position
        while(start<=end){
            //find where start index exceeds pivot
            while(arr[start]<pivot){
                start++;
            }
            //find where end index is less than pivot
            while(arr[end]>pivot){
                end--;
            }
            //swap the indices
            if(start<=end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }
}
