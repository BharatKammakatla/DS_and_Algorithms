package com.practice.recursion;

public class Palindrome {
    public static void main(String[] args) {
        int number = 12321;
        System.out.println(isPalindrome(number));
    }

    /*
    If a number is equal to the reverse of the number, then it's a palindrome.
     */
    static boolean isPalindrome(int n){
        int digits = (int) ((Math.log10(n))+1);
        return n == reverse(n, digits-1);
    }

    static int reverse(int n, int digits){
        int rem = n%10;
        if(rem == n){
            return n;
        }
        return rem*(int)Math.pow(10, digits) + reverse(n/10, digits-1);
    }
}
