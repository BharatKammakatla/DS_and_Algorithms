package com.practice.recursion.practice_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber lcpn = new LetterCombinationsOfPhoneNumber();
        String digits = "";
        System.out.println(lcpn.letterCombinations(digits));

    }
    public List<String> letterCombinations(String digits) {

        return digits.isEmpty()?new ArrayList<>():combinations("", digits);

    }

    public List<String> combinations(String p , String up){

        if(up.isEmpty()){
            List<String> last = new ArrayList<>();
            last.add(p);
            return last;
        }

        int digit = up.charAt(0) - '0';

        List<String> list = new ArrayList<>();

        int start = (digit-2)*3;
        int end = start + 3;
        if (digit==8 || digit==9){
            start++;
            end++;
        }
        if(digit==7 || digit==9 ) {
            end++;
        }


        for (int i = start; i < end; i++) {
            list.addAll(combinations(p+(char)('a'+i), up.substring(1)));
        }

        return list;
    }
}
