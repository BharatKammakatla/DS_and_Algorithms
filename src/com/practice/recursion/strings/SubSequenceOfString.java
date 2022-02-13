package com.practice.recursion.strings;

/*
Find all the subsets/subsequences of a given string
Ex: If abc the subsets are ["a", "b", "c", "ab", "ac", "bc", "abc", ""]
 */

import java.util.ArrayList;

public class SubSequenceOfString {
    public static void main(String[] args) {
        SubSequenceOfString ssos = new SubSequenceOfString();
        String s = "abc";
        System.out.println(ssos.subSequences("", s));
    }

    public ArrayList<String> subSequences(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> last = new ArrayList<>();
            last.add(p);
            return last;
        }

        char c = up.charAt(0);

        ArrayList<String> left = subSequences(p+c, up.substring(1));
        ArrayList<String> right = subSequences(p, up.substring(1));

        left.addAll(right);

        return left;
    }
}
