package com.practice.recursion.backtracking;

public class NQueens {
    public static void main(String[] args) {
        NQueens nqueens = new NQueens();
        int n = 5;
        boolean[][] board = new boolean[n][n];
        System.out.println(nqueens.printQueens(board, 0));

    }

    public int printQueens(boolean[][] board, int row){

        //base condition
        if(row == board.length){
            displayBoard(board);
            System.out.println();
            return 1;
        }

        int count = 0;
        //loop through each cell in the row and place the queen if its safe
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count += printQueens(board, row+1);
                board[row][col] = false;
            }
        }

        return count;
    }

    public boolean isSafe(boolean[][] board, int row, int col) {
        // check vertically
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }

        //check left diagonal
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }

        //check left diagonal
        int maxRight = Math.min(row, board.length-1-col);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }


    public void displayBoard(boolean[][] board){
        for(boolean[] row: board){
            for(boolean element: row){
                if(element){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
