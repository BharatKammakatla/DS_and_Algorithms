package com.practice.binary_search;

public class SmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        char[] input_array = {'c', 'f', 'j'};
        char target = 'f';
        System.out.println(nextGreatestLetter(input_array, target));
    }

    static char nextGreatestLetter(char[] letters, char target){
        int s = 0;
        int e = letters.length-1;
        while(s<=e){
            int m = s + (e-s)/2;
            if (target < letters[m]){
                e = m-1;
            }else{
                s = m+1;
            }
        }
        return letters[s%(letters.length)];
    }

}
