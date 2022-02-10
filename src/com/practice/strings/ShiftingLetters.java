package com.practice.strings;

public class ShiftingLetters {
    public static void main(String[] args) {
        ShiftingLetters sl = new ShiftingLetters();
        String s = "bad";
        int[] shifts = {10,20,30};
        System.out.println(sl.shiftingLetters(s, shifts));
    }

    public String shiftingLetters(String s, int[] shifts) {

        int len = s.length();

        int prevShifts = 0;

        StringBuilder sb = new StringBuilder(s);

        for (int i = len-1; i >=0; i--) {
            int val = shifts[i] + prevShifts;
            if(val>=26){
                val %= 26;
            }
            if(s.charAt(i) + val > 'z'){
                sb.setCharAt(i, (char)('a' + (sb.charAt(i) + val) - 'z' - 1));
            }else{
                sb.setCharAt(i, (char)(sb.charAt(i) + val));
            }
            prevShifts = val;
        }

        return sb.toString();
    }
}
