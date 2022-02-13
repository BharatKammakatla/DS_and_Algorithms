package com.practice.recursion.practice_problems;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString rs =  new ReverseString();
        char[] s = {'h','e','l','l','o'};
        rs.reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        reverse(s, 0, s.length-1);
    }

    public void reverse(char[] s, int start, int end) {
        if(start>=end){
            return;
        }

        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        reverse(s, start+1, end-1);
    }


}
