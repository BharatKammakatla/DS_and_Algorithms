package com.practice.strings;

public class SortingTheSentence {
    public static void main(String[] args) {
        SortingTheSentence sts = new SortingTheSentence();
        String s = s = "is2 sentence4 This1 a3";
        System.out.println(sts.sortSentence1(s));
    }

    public String sortSentence(String s) {
        String[] s_array = s.split(" ");

        int i = 0;

        while(i<s_array.length){
            int correct = s_array[i].charAt(s_array[i].length() - 1)-'0' - 1;
            if(s_array[i].charAt(s_array[i].length()-1)-'0' != s_array[correct].charAt(s_array[correct].length()-1)-'0'){
                String temp = s_array[i];
                s_array[i] = s_array[correct];
                s_array[correct] = temp;
            }else{
                i++;
            }
        }

        StringBuilder sb = new StringBuilder(s_array.length);
        for (String str : s_array) {
            sb.append(str.substring(0,str.length()-1));
            sb.append(" ");
        }
        sb.delete(sb.length()-1, sb.length());

        return sb.toString();
    }

    //Another approach
    public String sortSentence1(String s){
        String[] s_array = s.split(" ");
        String[] res = new String[s_array.length];

        int i;

        for (String value : s_array) {
            i = (int) value.charAt(value.length() - 1) - '0';
            res[i - 1] = value.substring(0, value.length() - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (i = 0; i < res.length - 1; i++) {
            sb.append(res[i]).append(" ");
        }
        sb.append(res[i]);

        return sb.toString();
    }
}
