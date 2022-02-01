package com.practice.sorting.practice_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        int[][] intervals = {{1,4},{1,5}};
        System.out.println(Arrays.deepToString(mi.merge1(intervals)));
    }

    public int[][] merge(int[][] intervals) {
        mergeSort(intervals, 0, intervals.length);
        List<int[]> resList = new ArrayList<>();

        int start = intervals[0][0];
        int end;
        int i = 1;

        while(i<intervals.length){
            if(intervals[i-1][1] < intervals[i][0]){
                end = intervals[i-1][1];
                resList.add(new int[]{start, end});
                start = intervals[i][0];
            }
            i++;
        }
        end = intervals[intervals.length-1][1];
        resList.add(new int[]{start, end});
        int[][] resArray = new int[resList.size()][2];
        resList.toArray(resArray);
        return resArray;
    }

    public void mergeSort(int[][] intervals, int start, int end) {
        //base condition
        if(end - start == 1){
            return;
        }
        int mid = start + (end-start)/2;
        mergeSort(intervals, start, mid);
        mergeSort(intervals, mid, end);
        mergeArrays(intervals, start, mid, end);
    }

    public void mergeArrays(int[][] arr, int start, int mid, int end) {
        int i = start;
        int j = mid;
        int k = 0;
        int[][] res = new int[end-start][2];
        while(i<mid && j<end){
            if(arr[i][0] < arr[j][0]){
                res[k][0] = arr[i][0];
                res[k][1] = arr[i][1];
                i++;
            }else{
                res[k][0] = arr[j][0];
                res[k][1] = arr[j][1];
                j++;
            }
            k++;
        }
        //fill the left out arrays
        while(i<mid){
            res[k][0] = arr[i][0];
            res[k][1] = arr[i][1];
            k++;
            i++;
        }
        while(j<end){
            res[k][0] = arr[j][0];
            res[k][1] = arr[j][1];
            k++;
            j++;
        }
        //replace the original array with res array
        for (int l = 0; l < res.length; l++) {
            arr[start+l][0] = res[l][0];
            arr[start+l][1] = res[l][1];
        }
    }

    //Efficient Method
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> resList = new ArrayList<>();
        int[] newInterval = intervals[0];
        resList.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }else{
                newInterval = interval;
                resList.add(newInterval);
            }
        }
        return resList.toArray(new int[resList.size()][]);
    }

}
