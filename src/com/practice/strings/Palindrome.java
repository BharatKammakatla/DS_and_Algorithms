package com.practice.strings;

public class Palindrome {
    public static void main(String[] args) {
        String word = "abcdcba";
        System.out.println(isPalindrome(word));
    }

    public static boolean isPalindrome(String word){
        if (word == null){
            return true;
        }
        int start = 0;
        int end = word.length()-1;
        while(start<end){
            if(word.charAt(start) == word.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}
