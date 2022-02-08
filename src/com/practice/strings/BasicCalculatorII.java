package com.practice.strings;

import java.util.Locale;

public class BasicCalculatorII {
    public static void main(String[] args) {
        BasicCalculatorII bsc = new BasicCalculatorII();
        String s = " 3+5*2-   4/2+6  ";
        System.out.println(bsc.calculate(s));
    }

    public int calculate(String s) {
        s = s.trim().replaceAll(" ", "");
        int len = s.length();

        int sum = 0;
        int preVal = 0;
        int i = 0;
        char prevSign = '+';

        while(i<len){

            int curVal = 0;
            while(i<len && Character.isDigit(s.charAt(i))){
              curVal = curVal*10 + (int) s.charAt(i)-'0';
              i++;
            }

            if(prevSign == '+'){
                sum += preVal;
                preVal = curVal;
            }else if(prevSign == '-'){
                sum += preVal;
                preVal = -curVal;
            }else if(prevSign == '*'){
                preVal *= curVal;
            }else if(prevSign == '/'){
                preVal /= curVal;
            }

            if(i<len) {
                prevSign = s.charAt(i);
                i++;
            }
        }
        sum += preVal;
        return sum;
    }
}
