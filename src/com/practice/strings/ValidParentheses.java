package com.practice.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String s = "{[]}";
        System.out.println(vp.isValid(s));
    }

//    public boolean isValid(String s) {
//        List<Character> ls = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            if(ls.size() == 0){
//                ls.add(s.charAt(i));
//            }else if(s.charAt(i) == ')' && ls.get(ls.size()-1)=='('){
//                ls.remove(ls.size()-1);
//            }else if(s.charAt(i) == '}' && ls.get(ls.size()-1)=='{'){
//                ls.remove(ls.size()-1);
//            }else if(s.charAt(i) == ']' && ls.get(ls.size()-1)=='['){
//                ls.remove(ls.size()-1);
//            }else{
//                ls.add(s.charAt(i));
//            }
//        }
//        return ls.size()==0;
//    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else{
                if(stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
        }
        return true;
    }
    
}
