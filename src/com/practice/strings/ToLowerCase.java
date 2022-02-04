package com.practice.strings;

import java.util.Locale;

public class ToLowerCase {
    public static void main(String[] args) {
        ToLowerCase tlc = new ToLowerCase();
        String s = "al&phaBET";
        System.out.println(tlc.toLowerCase(s));
    }

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >='A' && s.charAt(i) <= 'Z'){
                sb.append((char)(s.charAt(i) + 32));
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
