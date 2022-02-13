package com.practice.recursion.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetOfArray {
    public static void main(String[] args) {
        SubSetOfArray ssoa = new SubSetOfArray();
        int[] array = {1, 2, 2};
        List<List<Integer>> ans = ssoa.subsetDuplicates(array);
        for (List<Integer> list: ans){
            System.out.println(list);
        }
    }

    public List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }

        return outer;
    }

    public List<List<Integer>> subsetDuplicates(int[] arr){
        /*
        1. When you find a duplicate only add it to the newly created subset from the previous step
        2. If the duplicates are not adjacent out login would fail. So, incase of non-adjacent duplicates, sort the array and make them adjacent.
         */
        Arrays.sort(arr);

        List<List<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());

        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {

            start = 0;

            //if previous element is equal to current element, then new start would be previous end + 1
            if(i>0 && arr[i] == arr[i-1]){
                start = end+1;
            }
            end = outer.size()-1;
            for (int j = start; j <= end; j++) {
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }

        return outer;
    }
}
