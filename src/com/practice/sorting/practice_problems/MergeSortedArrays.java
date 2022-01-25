package com.practice.sorting.practice_problems;
//https://leetcode.com/problems/merge-sorted-array/

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0;
        int j = 0;
        int k = 0;
        int[] mergedArray = new int[m+n];

        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                mergedArray[k]=nums1[i];
                i++;
            }else{
                mergedArray[k]=nums2[j];
                j++;
            }
            k++;
        }

        //Fill the left out array
        while(i<m){
            mergedArray[k]=nums1[i];
            i++;
            k++;
        }
        while(j<n){
            mergedArray[k]=nums2[j];
            j++;
            k++;
        }

        //Replace nums1 with mergedArray
        System.arraycopy(mergedArray, 0, nums1, 0, mergedArray.length);
    }
}
