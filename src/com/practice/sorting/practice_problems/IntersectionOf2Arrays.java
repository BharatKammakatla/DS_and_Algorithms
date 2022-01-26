package com.practice.sorting.practice_problems;

// https://leetcode.com/problems/intersection-of-two-arrays/

import java.util.*;

public class IntersectionOf2Arrays {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection2(nums1, nums2)));
    }

    // Method 1
    public static int[] intersection1(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int num : nums1) {
            hm.put(num, 0);
        }

        for (int num : nums2) {
            if(hm.get(num)!=null){
                hm.put(num, 1);
            }
        }

        hm.values().removeIf(value -> value.equals(0));

        int[] res = new int[hm.size()];
        //Converting Set object to integer res
        int j = 0;
        for (int i: hm.keySet()) {
            res[j++] = i;
        }
        return res;
    }

    // Method 2
    public static int[] intersection2(int[] nums1, int[] nums2) {

        HashSet<Integer> hs = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums1) {
            hs.add(num);
        }

        for (int num : nums2) {
            if(hs.contains(num)){
                list.add(num);
                hs.remove(num);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
