package com.practice.strings;

import java.util.Map;
import java.util.TreeMap;

public class ShuffleString {
    public static void main(String[] args) {
        ShuffleString ss = new ShuffleString();
        int[] indices = {4,5,6,7,0,2,1,3};
        String s = "codeleet";
        System.out.println(ss.restoreString(s, indices));

    }

    public String restoreString(String s, int[] indices) {

        char[] ch = new char[indices.length];

        for (int i = 0; i < indices.length; i++) {
            ch[indices[i]]=s.charAt(i);
        }

        return String.valueOf(ch);

    }
}
