package com.practice.strings;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        BasicCalculator bs = new BasicCalculator();
        String s = "(3 - (4 + 5))";
        System.out.println(bs.calculate(s));
    }

    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else if (c == '+') {
                result = result + sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result = result + sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result = result + sign * number;
                number = 0;
                result = result * stack.pop();
                result = result + stack.pop();
            }
        }
        if(number != 0){
            result = result + sign*number;
        }
        return result;
    }

}
