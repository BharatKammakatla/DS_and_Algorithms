package com.practice.sorting.practice_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        MinimumAbsoluteDifference mad = new MinimumAbsoluteDifference();
        int[] arr = {3,8,-10,23,19,-4,-14,27};
        System.out.println(mad.minimumAbsDifference(arr));
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        mergeSort(arr, 0, arr.length);

        List<List<Integer>> list = new ArrayList<>();

        int minDiff = arr[1] - arr[0];
        list.add(Arrays.asList(arr[0], arr[1]));
        for (int i = 2; i < arr.length; i++) {
            if(arr[i] - arr[i-1] < minDiff){
                minDiff = arr[i] - arr[i-1];
                list.clear();
                list.add(Arrays.asList(arr[i-1], arr[i]));
            }else if (arr[i] - arr[i-1] == minDiff){
                list.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return list;
    }

    private void mergeSort(int[] arr, int start, int end) {
        //base condition
        if(end-start == 1){
            return;
        }
        int mid = start + (end - start)/2;
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
        //Fill the left out array
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

        //replace the original array with result array
        for (int l = 0; l < res.length; l++) {
            arr[start+l] = res[l];
        }
    }
}
