package com.practice.strings;

public class SentenceSimilarityIII {
    public static void main(String[] args) {
        SentenceSimilarityIII ss = new SentenceSimilarityIII();
        String sentence1 = "Eating right now";
        String sentence2 = "Eating";
        System.out.println(ss.areSentencesSimilar(sentence1, sentence2));
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int l1 = words1.length;
        int l2 = words2.length;

        if(l1>l2){
            return areSentencesSimilar(sentence2, sentence1);
        }

        int i = 0;
        while(i<l1 && words1[i].equals(words2[i])){
            ++i;
        }
        while(i<l1 && words1[i].equals(words2[l2-l1+i])){
            ++i;
        }
        return i==l1;
    }
}
