package com.practice.recursion.practice_problems;

public class KthSymbolInGrammar {
    public static void main(String[] args) {
        KthSymbolInGrammar ksg = new KthSymbolInGrammar();
        int n = 4;
        int k = 6;
        System.out.println(ksg.kthGrammar(n, k));
    }

    public int kthGrammar(int n, int k) {
        if(n==1){
            return 0;
        }
        //base condition
        if(n==2 && k==1){
            return 0;
        }
        if(n==2 && k==2){
            return 1;
        }

        if(k%2==0){
            k--;
            return kthGrammar(n-1, k/2+1) == 0 ? 1 : 0;
        }else{
            return kthGrammar(n-1, k/2+1);
        }

    }
}
