package com.practice.recursion.backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        Maze mx = new Maze();
//        System.out.println(mx.countPaths(3,3));
//        System.out.println(mx.printPathsList("", 3, 3));
//        System.out.println(mx.printPathsListWithDiagonal("", 3, 3));
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
    }

    public int countPaths(int row, int col){
        //base condition
        if(row == 1 || col ==1){
            return 1;
        }

        int leftCount = countPaths(row-1, col);
        int rightCount = countPaths(row, col-1);

        return leftCount + rightCount;
    }

    public void printPaths(String p, int row, int col){
        //base condition
        if(row == 1 && col ==1){
            System.out.println(p);
            return;
        }

        if(row>1)
            printPaths(p+"D", row-1, col);
        if(col>1)
            printPaths(p+"R", row, col-1);
    }

    public ArrayList<String> printPathsList(String p, int row, int col){
        //base condition
        if(row == 1 && col ==1){
            ArrayList<String> last = new ArrayList<>();
            last.add(p);
            return last;
        }

        ArrayList<String> list = new ArrayList<>();
        if(row>1) {
            list.addAll(printPathsList(p + "D", row - 1, col));
        }
        if(col>1) {
            list.addAll(printPathsList(p + "R", row, col - 1));
        }

        return list;
    }

    public ArrayList<String> printPathsListWithDiagonal(String p, int row, int col){
        //base condition
        if(row == 1 && col ==1){
            ArrayList<String> last = new ArrayList<>();
            last.add(p);
            return last;
        }

        ArrayList<String> list = new ArrayList<>();
        if(row>1 && col>1) {
            list.addAll(printPathsListWithDiagonal(p + "D", row - 1, col-1));
        }
        if(row>1) {
            list.addAll(printPathsListWithDiagonal(p + "V", row - 1, col));
        }
        if(col>1) {
            list.addAll(printPathsListWithDiagonal(p + "H", row, col - 1));
        }

        return list;
    }

    public void printPathsWithObstacles(String p, boolean[][] maze, int row, int col){
        //base condition
        if(row == maze.length-1 && col ==maze[0].length-1){
            System.out.println(p);
            return;
        }

        //to handle obstacles
        if(!maze[row][col]){
            return;
        }

        if(row < maze.length-1)
            printPathsWithObstacles(p+"D", maze,row+1, col);
        if(col < maze[0].length-1)
            printPathsWithObstacles(p+"R", maze, row, col+1);

    }

}
