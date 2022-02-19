package com.practice.recursion.practice_problems;

import java.util.stream.Stream;

public class SudokuSolver {

    public static void main(String[] args) {
        SudokuSolver ss = new SudokuSolver();
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        ss.solveSudoku(board);

    }

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private void solve(char[][] board, int row, int col) {
        //base condition
        if(row == board.length){
            displayBoard(board);
            return;
        }

        //move to next row if end of the columns is reached
        if(col == board.length){
            solve(board, row+1, 0);
            return;
        }


        //check if cell is empty
        if(board[row][col]!='.'){
            solve(board, row, col+1);
            return;
        }

        for (int num = 1; num <= 9; num++) {
            if(isAllowed(board, row, col, (char)('0'+num))) {
                board[row][col] = (char)('0'+num);
                solve(board, row, col + 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean isAllowed(char[][] board, int row, int col, char num) {
        //check row
        for (int i = 0; i < board.length; i++) {
            if(board[row][i]==num){
                return false;
            }
        }

        //check col
        for (int i = 0; i < board.length; i++) {
            if(board[i][col]==num){
                return false;
            }
        }

        //check sub box
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for (int i = startRow; i < startRow+3; i++) {
            for (int j = startCol; j < startCol+3; j++) {
                if(board[i][j]==num){
                    return false;
                }
            }
        }

        return true;
    }

    private void displayBoard(char[][] board) {
        for(char[] row : board) {
            for(char num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
