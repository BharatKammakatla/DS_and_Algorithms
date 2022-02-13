package com.practice.recursion.strings;

public class SkipCharacter {
    public static void main(String[] args) {
        SkipCharacter sc = new SkipCharacter();
        String s = "abbacdeagh";
        System.out.println(sc.skip(s));
    }

    public String skip(String up){
        if(up.isEmpty()){
            return "";
        }

        char c = up.charAt(0);
        if(c == 'a'){
            return skip(up.substring(1));
        }else{
            return c + skip(up.substring(1));
        }

    }

}
