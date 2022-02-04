package com.practice.strings;

public class LengthOfLastWord {
    public static void main(String[] args) {
        LengthOfLastWord lolw = new LengthOfLastWord();
        String s = "   fly me   to   the moon  ";
        System.out.println(lolw.lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        return s.split(" ")[s.split( " ").length -1].length();
    }
}
