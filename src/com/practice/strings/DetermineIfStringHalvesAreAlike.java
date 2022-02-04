package com.practice.strings;

import java.util.ArrayList;
import java.util.List;

public class DetermineIfStringHalvesAreAlike {
    public static void main(String[] args) {
        DetermineIfStringHalvesAreAlike dishaa = new DetermineIfStringHalvesAreAlike();
        String s = "book";
        System.out.println(dishaa.halvesAreAlike(s));
    }

//    public boolean halvesAreAlike(String s) {
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' ||
//                    s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U'){
//                if(i<s.length()/2){
//                    count++;
//                }else{
//                    count--;
//                }
//            }
//        }
//        return count == 0;
//    }

    public boolean halvesAreAlike(String s) {
        int diff = 0;
        int mid = s.length()/2;
        for (int i = 0; i < mid; i++) {
            diff = diff + (isVowel(s.charAt(i)) - isVowel(s.charAt(mid+i)));
        }
        return diff == 0;
    }

    int isVowel(Character c){
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return 1;
        }else{
            return 0;
        }
    }
}
