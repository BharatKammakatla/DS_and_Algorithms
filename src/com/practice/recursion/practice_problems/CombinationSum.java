package com.practice.recursion.practice_problems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = {2,7,6,3,5,1};
        int target = 9;
        System.out.println(cs.combinationSum(candidates, target));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return getCombos(candidates, 0, new ArrayList<>(), target);
    }

    public List<List<Integer>> getCombos(int[] arr, int start, List<Integer> list, int target){
        List<List<Integer>> finalList = new ArrayList<>();
        if(target == 0){
            List<List<Integer>> last = new ArrayList<>();
            last.add(new ArrayList<>(list));
            return last;
        }

        List<Integer> innerList = new ArrayList<>(list);

        for (int i = start; i < arr.length; i++) {
            if(target-arr[i] >= 0) {
                innerList.add(arr[i]);
                finalList.addAll(getCombos(arr, i, innerList, target - arr[i]));
                innerList.remove(innerList.size() - 1);
            }
        }

        return finalList;
    }


}
