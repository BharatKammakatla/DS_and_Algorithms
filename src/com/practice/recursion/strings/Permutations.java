package com.practice.recursion.strings;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Permutations pm = new Permutations();
        String str = "abc";
        System.out.println(pm.permutationsCount("", str));
    }

    public void permutations(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            permutations(f+ch+s, up.substring(1));
        }
    }

    public ArrayList<String> permutationsList(String p, String up){

        if(up.isEmpty()){
            ArrayList<String> last = new ArrayList<>();
            last.add(p);
            return last;
        }
        char ch = up.charAt(0);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            list.addAll(permutationsList(f+ch+s, up.substring(1)));
        }
        return list;
    }

    public int permutationsCount(String p, String up){

        if(up.isEmpty()){
            return 1;
        }
        char ch = up.charAt(0);
        int count = 0;
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0,i);
            String s = p.substring(i, p.length());
            count += permutationsCount(f+ch+s, up.substring(1));
        }
        return count;
    }
}
