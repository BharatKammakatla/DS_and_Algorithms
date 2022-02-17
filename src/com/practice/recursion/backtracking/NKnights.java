package com.practice.recursion.backtracking;

public class NKnights {
    public static void main(String[] args) {
        NKnights nKnights = new NKnights();
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(nKnights.printKnights(board, 0, 0, 4));
    }

    public int printKnights(boolean[][] board, int row, int col, int target){
        //base condition 1
        if(target==0){
            displayBoard(board);
            System.out.println();
            return 1;
        }

        //move to next when we reach end of the column
        if(col==board.length) {
            row = row + 1;
            col = 0;
        }

        //base condition 2
        if(row == board.length){
            return 0;
        }

        int count = 0;

        if(isSafe(board, row, col)){
            board[row][col] = true;
            count += printKnights(board, row, col+1, target-1);
            board[row][col] = false;
        }
        count += printKnights(board, row, col+1, target);

        return count;
    }

    private boolean isSafe(boolean[][] board, int row, int col) {
        //check row-1 moves
        if(row-1 >= 0 && col-2 >= 0 && board[row-1][col-2])
            return false;
        if(row-1 >= 0 && col+2 < board.length && board[row-1][col+2])
            return false;

        //check row-2 moves
        if(row-2 >= 0 && col-1 >= 0 && board[row-2][col-1])
            return false;
        if(row-2 >= 0 && col+1 < board.length && board[row-2][col+1])
            return false;

        return true;
    }

    private void displayBoard(boolean[][] board) {
        for(boolean[] row: board){
            for(boolean element: row){
                if(element){
                    System.out.print("K ");
                }else{
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
}
