package com.practice.strings;

public class SplitTwoStringsToMakePalindrome {
    public static void main(String[] args) {
        SplitTwoStringsToMakePalindrome sp = new SplitTwoStringsToMakePalindrome();
        String a = "ulacfd";
        String b = "jizalu";
        System.out.println(sp.checkPalindromeFormation2(a, b));
    }

    //brute force
    public boolean checkPalindromeFormation1(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if(isPalindrome(a.substring(0,i) + b.substring(i, b.length())) || isPalindrome(b.substring(0,i) + a.substring(i, a.length()))){
                return true;
            }
        }
        return false;
    }

    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }
        return i>=j;
    }

    //Efficient wat - (Greedy - Two Pointer algorithm)
    public boolean checkPalindromeFormation2(String a, String b) {
        return check(a, b) || check(b,a);
    }

    public boolean check(String a, String b) {
        int i = 0;
        int j = a.length()-1;
        while(i<j && a.charAt(i) == b.charAt(j)){
            i++;
            j--;
        }
        if(i<j){
            return isPalindrome(a,i,j) || isPalindrome(b,i,j);
        }else{
            return true;
        }
    }

    public boolean isPalindrome(String s, int i, int j){
        while(i<j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }
        return i>=j;
    }


}
