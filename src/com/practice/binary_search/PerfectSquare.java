package com.practice.binary_search;

public class PerfectSquare {
    public static void main(String[] args) {
        int n = 808201;
        System.out.println(isPerfectSquare(n));

    }
    public static boolean isPerfectSquare(int num) {
        int start=1;
        int end=num/2;
        if(num==1){
            return true;
        }
        while(start<=end){
            long mid = start + (end-start)/2;
            long square = mid*mid;
            if(square>num){
                end= (int) (mid-1);
            }else if(square<num){
                start= (int) (mid+1);
            }else{
                return true;
            }
        }
        return false;
    }
}
