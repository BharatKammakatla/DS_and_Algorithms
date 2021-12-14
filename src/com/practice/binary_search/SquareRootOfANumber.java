package com.practice.binary_search;

public class SquareRootOfANumber {

    public static void main(String[] args) {
        int num = 2147395599;
        System.out.println(findSquareRoot(num));
    }

    public static int findSquareRoot(int num){
        long start = 1;
        long end = num/2;

        if(num == 1){
            return 1;
        }
        while(start<=end){
            long mid = start + (end-start)/2;
            if(num>mid*mid){
                start = mid + 1;
            }else if(num<mid*mid){
                end = mid - 1;
            }else{
                return (int) mid;
            }
        }
        return (int) end;
    }

}
