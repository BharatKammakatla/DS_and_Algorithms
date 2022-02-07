package com.practice.strings;

import java.util.Arrays;

public class NextGreaterElementIII {
    public static void main(String[] args) {
        NextGreaterElementIII nge = new NextGreaterElementIII();
        int n = 11221144;
        System.out.println(nge.nextGreaterElement(n));
    }


    public int nextGreaterElement(int n) {

        char[] number = String.valueOf(n).toCharArray();
        int len = number.length;
        int i, j;

        //Step 1
        /*
        Start form right most and find the first digit that is smaller than the previous digit
         */
        for (i = len-1; i >=1 ; i--) {
            if(number[i-1] < number[i]){
                break;
            }
        }

        //if no such element is found, return -1.
        if(i==0){
            return -1;
        }

        //Step 2
        /*
        find the smallest element on the right side of (i-1)th digit that is
        greater than number[i-1]
         */
        int x = number[i-1];
        int smallest = i;
        for (j = i+1; j < len; j++) {
            if(number[j]>x && number[j] <=number[smallest]){
                smallest = j;
            }
        }

        //Step 3
        /*
        Swap the (i-1)th digit with smallest digit
         */
        char temp = number[i-1];
        number[i-1] = number[smallest];
        number[smallest] = temp;

        //Step 4
        /*
        Sort the array that is right to (i-1)th digit
         */
        Arrays.sort(number, i, len);

        //check if the value is less than the max integer value
        long val = Long.parseLong(new String(number));
        return val <= Integer.MAX_VALUE ? (int) val : -1;

    }



}
