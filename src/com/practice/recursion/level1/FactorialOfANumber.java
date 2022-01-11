package com.practice.recursion.level1;

public class FactorialOfANumber {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    static int factorial(int n){
        //base condition
        if (n<2){
            return 1;
        }
        return n * factorial(n-1);
    }
}
