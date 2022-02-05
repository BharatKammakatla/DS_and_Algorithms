package com.practice.strings;

public class JumpGameVII {
    public static void main(String[] args) {
        JumpGameVII jmp = new JumpGameVII();
        String s = "011010";
        int minJump = 2;
        int maxJump = 3;
        System.out.println(jmp.canReach(s, minJump, maxJump));
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        int i = 0;
        while(i<s.length()-minJump){
            if(i+maxJump<s.length()-1)
                i = searchJ(s, i+minJump, i+maxJump);
            else
                i = searchJ(s, i+minJump, s.length()-1);

            if(i==-1){
                return false;
            }
        }
        return i == s.length()-1;
    }

    private int searchJ(String s, int start, int end) {
        int i = end;
        while(i>=start){
            if(s.charAt(i)=='0'){
                return i;
            }
            i--;
        }
        return -1;
    }
}
