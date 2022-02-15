package com.practice.recursion.practice_problems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(cs.combinationSum(candidates, target));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return getCombos(candidates, new ArrayList<>(), target);
    }

    public List<List<Integer>> getCombos(int[] candidates, List<Integer> list, int target){
        List<List<Integer>> finalList = new ArrayList<>();
        if(target == 0){
            List<List<Integer>> last = new ArrayList<>();
            last.add(list);
            return last;
        }

        List<Integer> innerList = new ArrayList<>(list);
        for (int num: candidates){
            if(target-num>=0){
                innerList.add(num);
                finalList.addAll(getCombos(candidates, innerList, target-num));
            }
        }

        return finalList;
    }


}
