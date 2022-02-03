package com.practice.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountItemsMatchingRule {
    public static void main(String[] args) {
        CountItemsMatchingRule cimr = new CountItemsMatchingRule();
        List<List<String>> items = new ArrayList<>();
        items.add(new ArrayList<>());
        String ruleKey = "color";
        String ruleValue = "silver";
        System.out.println(cimr.countMatches(items, ruleKey, ruleValue));

    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List<String> s : items) {
            if(ruleKey.equals("type")){
                if(s.get(0).equals(ruleValue)){
                    count++;
                }
            }else if(ruleKey.equals("color")){
                if(s.get(1).equals(ruleValue)){
                    count++;
                }
            }else{
                if(s.get(2).equals(ruleValue)){
                    count++;
                }
            }
        }
        return count;
    }
}
