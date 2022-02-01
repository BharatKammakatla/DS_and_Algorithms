package com.practice.sorting.practice_problems;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        mergeSort(strs, 0, strs.length);
        System.out.println(ga.groupAnagrams2(strs));
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        mergeSort(strs, 0, strs.length);
        List<List<String>> list = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        tempList.add(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            if(compare(strs[i],strs[i-1])==0){
                tempList.add(strs[i]);
            }else{
                list.add(new ArrayList<>(tempList));
                tempList.clear();
                tempList.add(strs[i]);
            }
        }
        list.add(new ArrayList<>(tempList));

        return list;
    }

    public static void mergeSort(String[] strs, int start, int end) {
        if(end - start == 1){
            return;
        }
        int mid = start + (end-start)/2;
        mergeSort(strs, start, mid);
        mergeSort(strs, mid, end);
        merge(strs, start, mid, end);
    }

    public static void merge(String[] arr, int start, int mid, int end){
        int i = start;
        int j = mid;
        String[] res = new String[end-start];
        int k = 0;

        while(i<mid && j<end){
            if(compare(arr[i],arr[j]) < 0){
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
            res[k] = arr[i];
            i++;
            k++;
        }
        while(j<end){
            res[k] = arr[j];
            j++;
            k++;
        }
        //replace the original array with res array
        for (int l = 0; l < res.length; l++) {
            arr[start+l] = res[l];
        }
    }

    public static int compare(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.compare(c1,c2);
    }

    //Method 2 (Efficient)
    //Instead of sorting, we can also build the key string in this way.
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] ca = new int[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            int keyStr = Arrays.hashCode(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

}
