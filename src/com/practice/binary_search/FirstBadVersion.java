package com.practice.binary_search;

public class FirstBadVersion {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(firstBadVersion(n));
    }

    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start<end){
            int mid = start + (end - start)/2;
            if(isBadVersion(mid)){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return end;
    }

    // Dummy API interface
    private static boolean isBadVersion(int mid) {
        return true;
    }
}
