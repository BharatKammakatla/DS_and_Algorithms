package com.practice.binary_search;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 5;
        System.out.println(minEatingSpeed(piles, h));

    }
    public static int minEatingSpeed(int[] piles, int h) {

        int start = 1;
        int end = piles[0];

        for (int i =1; i<piles.length; i++) {
            end = Math.max(end, piles[i]);
        }

        while(start<=end){
            int mid = start + (end-start)/2;
            int count = 0;

            for(int num:piles){
                if(num/mid>=1){
                    count = count + num/mid;
                    if(num%mid>0){
                        count++;
                    }
                }else {
                    count++;
                }
            }

            if(count>h){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
}
