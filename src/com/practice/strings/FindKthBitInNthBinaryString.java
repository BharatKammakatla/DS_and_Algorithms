package com.practice.strings;

import java.util.Locale;

public class FindKthBitInNthBinaryString {
    public static void main(String[] args) {
        FindKthBitInNthBinaryString fkbs = new FindKthBitInNthBinaryString();
        System.out.println(fkbs.findKthBit2(3,3));
    }

    public char findKthBit(int n, int k) {

        String prevStr = "0";
        String currStr = "";
        StringBuilder sb = new StringBuilder(prevStr.length());

        for (int i = 2; i <= n; i++) {
            //find the inverse of prev string
            for (int j = 0; j < prevStr.length(); j++) {
                if(prevStr.charAt(j) == '0'){
                    sb.append('1');
                }else{
                    sb.append('0');
                }
            }
            //reverse the string
            sb.reverse();

            currStr = prevStr + "1" + sb.toString();

            if(k<=currStr.length()){
                return currStr.charAt(k-1);
            }
            prevStr = currStr;
            sb.delete(0, sb.length());
        }

        return '0';
    }

    //Efficient Solution 1
    public char findKthBit1(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('0');
        for (int i = 2, l=1; i <= n; i++) {
            String toAdd = reverseAndInvert(sb);
            sb.append('1').append(toAdd);
            l = l*2+1;

            if (k<=l) return sb.charAt(k-1);
        }

        return 0;
    }

    public String reverseAndInvert(StringBuilder s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >=0; i--) {
            sb.append(s.charAt(i) == '0' ? '1':'0');
        }
        return sb.toString();
    }

    //Efficient Solution 2
    public  char findKthBit2(int n, int k){

        if(n == 1 || k==1){
            return '0';
        }

        int len = (int) Math.pow(2,n) - 1;
        int mid = (len + 2)/2;

        if (k==mid)
            return '1';

        if (k< mid)
            return findKthBit2(n-1, k);

        int prevLen = mid - 1;
        int prevBitPositionFromStart = k-mid;

        return findKthBit2(n-1, prevLen-prevBitPositionFromStart+1) == '0'?'1':'0';
    }


}
