package com.practice.recursion.practice_problems;

import java.util.Arrays;
import java.util.Objects;

public class WordSearch {
    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(ws.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (findWord(board, word, row, col)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findWord(char[][] board, String word, int row, int col){
        //base condition
        if(word.equals("")){
            return true;
        }
        if (row < 0 || col < 0 || row==board.length || col==board[row].length){
            return false;
        }

        if(board[row][col] != word.charAt(0)){
            return false;
        }

        //mark the current cell as covered
        char currChar = board[row][col];
        board[row][col] = '#';

        boolean status = findWord(board, word.substring(1), row+1, col) ||
                findWord(board, word.substring(1), row-1, col) ||
                findWord(board, word.substring(1), row, col+1) ||
                findWord(board, word.substring(1), row, col-1);

        board[row][col] = currChar;

        return status;

    }

}


