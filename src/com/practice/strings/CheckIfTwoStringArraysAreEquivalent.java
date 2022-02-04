package com.practice.strings;

public class CheckIfTwoStringArraysAreEquivalent {
    public static void main(String[] args) {
        CheckIfTwoStringArraysAreEquivalent citaae = new CheckIfTwoStringArraysAreEquivalent();
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(citaae.arrayStringsAreEqual(word1, word2));
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder sb1 = new StringBuilder(word1.length);
        for (String str1 : word1) {
            sb1.append(str1);
        }

        StringBuilder sb2 = new StringBuilder(word2.length);
        for (String str2 : word2) {
            sb2.append(str2);
        }

        return sb1.toString().equals(sb2.toString());
    }
}
