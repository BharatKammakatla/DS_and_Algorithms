package com.practice.binary_search;

// https://leetcode.com/problems/arranging-coins/

public class ArrangingCoins {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(arrangeCoins(n));
    }

//    public static int arrangeCoins(int n) {
//
//        long k = 1;
//        long end = 1;
//
//        while(true){
//            if(n == end){
//                return (int) k;
//            }else if(n > end){
//                end = end + k + 1;
//                k++;
//            }else{
//                return (int) k-1; // this case means n >= start and n < end
//            }
//        }
//
//    }

//    public static int arrangeCoins(int n) {
//
//        long k = 1;
//        long res = 1;
//
//        while(res < n){
//            k++;
//            res += k;
//        }
//        if(res == n){
//            return (int) k;
//        }else{
//            return (int) k-1;
//        }
//
//    }

    public static int arrangeCoins(int n){
        long start = 0;
        long end = n;
        while ( start <= end){
            long mid = start + (end-start)/2;
            long sum = (mid*(mid+1))/2;
            if ( n > sum ){
                start = mid + 1;
            }else if (n < sum){
                end = mid - 1;
            }else{
                return (int) mid;
            }
        }
        return (int) end;
    }

}
