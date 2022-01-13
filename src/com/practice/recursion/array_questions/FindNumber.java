package com.practice.recursion.array_questions;

import java.util.ArrayList;

public class FindNumber {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 12, 17, 12};
        System.out.println(findIndex(arr, 12, 0));
        System.out.println(findAllIndex(arr, 12, 0, new ArrayList<>()));
        System.out.println(findAllIndex2(arr, 12, 0));
    }

    static int findIndex(int[] arr, int target, int index){
        //base condition
        if(index==arr.length){
            return -1;
        }
        return arr[index]==target ? index : findIndex(arr, target, index+1);
    }

    static ArrayList<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list){
        //base condition
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        return findAllIndex(arr, target, index+1, list);
    }

    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index){

        ArrayList<Integer> list = new ArrayList<>();

        //base condition
        if(index == arr.length){
            return list;
        }

        // this will contain the ans for that function call only
        if(arr[index]==target){
            list.add(index);
        }

        ArrayList<Integer> ansFromBelowCalls = findAllIndex2(arr, target, index+1);

        list.addAll(ansFromBelowCalls);

        return list;
    }

}
