package com.practice.recursion.level1;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println(reverseNumber(1789));
    }

    static int reverseNumber(int n){
        int sum = 0;
        while (n>0){
            if (n%10 == n){
                return sum + n;
            }

            sum = 10*(sum + (n%10));
            n = n/10;
        }
        return -1;
    }

    static int reverseNumber_recursion(int n, int sum){
        if (n%10 == n){
            return sum + n;
        }
        sum = 10*(sum + (n%10));
        return reverseNumber_recursion(n/10, sum);
    }
}
