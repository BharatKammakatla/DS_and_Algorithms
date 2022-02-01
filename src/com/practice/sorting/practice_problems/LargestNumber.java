package com.practice.sorting.practice_problems;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        int[] nums = {3,30,34,5,9};
        System.out.println(ln.largestNumber(nums));
    }

    public String largestNumber(int[] nums) {

        if(nums == null || nums.length == 0)
            return "";

        //convert integer array to string array
        String[] s_nums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s_nums[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };

        Arrays.sort(s_nums, comp);

        //special case
        if(s_nums[0].charAt(0) == '0'){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String s: s_nums){
            sb.append(s);
        }

        return sb.toString();
    }
}
