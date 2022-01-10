package com.practice.recursion;

public class CountZeros {
    public static void main(String[] args) {
        System.out.println(countZeros(50400, 0));
    }

    // Method 1 (Passing the count as an argument)
    // Special pattern: How to pass a number(return value) to above recursion calls
    static int countZeros(int n, int count){
        if (n==0) {
            return count;
        }

        int rem = n%10;
        if (rem == 0){
            return countZeros(n/10, count+1);
        }
        return countZeros(n/10, count);
    }
}
