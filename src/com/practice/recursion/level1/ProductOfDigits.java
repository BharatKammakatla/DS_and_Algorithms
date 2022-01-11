package com.practice.recursion.level1;

public class ProductOfDigits {
    public static void main(String[] args) {
        int number = 158;
        System.out.println(productOfDigits(number));
    }
    static int productOfDigits(int n){
        //if one digit is remaining, then return the digit itself.
        if(n%10 == n){
            return n;
        }
        return n%10 * productOfDigits(n/10);
    }
}
