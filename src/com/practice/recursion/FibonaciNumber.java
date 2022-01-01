package com.practice.recursion;

public class FibonaciNumber {
    public static void main(String[] args) {
        int num = 4;
        System.out.println(fibonaci(num));
    }
    public static int fibonaci(int n){
        // base condition
        if (n<2){
            return n;
        }
        return fibonaci(n-1) + fibonaci(n-2);
    }
}
