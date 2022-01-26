package com.practice.sorting.practice_problems;

// https://leetcode.com/problems/intersection-of-two-arrays-ii/

import java.util.*;

public class IntersectionOf2Arrays2 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    // Method 1
    public static int[] intersection(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> resList = new ArrayList<>();

        for (int num : nums1) {
            if(hm.get(num)==null){
                hm.put(num, 1);
            }else{
                hm.put(num, hm.get(num)+1);
            }
        }

        for (int num : nums2) {
            if(hm.get(num)!=null){
                int count = hm.get(num);
                if(count==0){
                    hm.remove(num);
                }else{
                    resList.add(num);
                    hm.put(num, --count);
                }
            }
        }

        return resList.stream().mapToInt(i -> i).toArray();
    }

}
