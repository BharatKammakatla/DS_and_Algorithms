package com.practice.recursion.level1;

public class SumOfDigits {
    public static void main(String[] args) {
        int number = 999999999;
        System.out.println(sumOfDigits(number));
    }
    static int sumOfDigits(int n){
        if(n==0){
            return 0;
        }
        return n%10 + sumOfDigits(n/10);
    }
}
