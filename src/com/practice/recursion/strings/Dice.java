package com.practice.recursion.strings;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    public static void main(String[] args) {
        Dice dice = new Dice();
        System.out.println(dice.diceCombinations("",4));
    }

    public List<String> diceCombinations(String p, int target){

        if(target==0){
            List<String> last = new ArrayList<>();
            last.add(p);
            return last;
        }

        List<String> list = new ArrayList<>();

        for (int i = 1; i <= target; i++) {
            list.addAll(diceCombinations(p+i, target-i));
        }

        return list;
    }
}
