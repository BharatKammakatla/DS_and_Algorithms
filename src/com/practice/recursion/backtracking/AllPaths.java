package com.practice.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class AllPaths {
    public static void main(String[] args) {
        AllPaths ap = new AllPaths();
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[maze.length][maze[0].length];
        ap.allPathsPrint("", maze, 0, 0, path, 1);
    }

    public void printPathsAllDirections(String p, boolean[][] maze, int row, int col){
        //base condition
        if(row == maze.length-1 && col ==maze[0].length-1){
            System.out.println(p);
            return;
        }

        //to handle obstacles
        if(!maze[row][col]){
            return;
        }

        //Marking current cell as false
        //(*** make a change before starting your work - Backtracking 1 ***)
        maze[row][col] = false;


        if(row < maze.length-1)
            printPathsAllDirections(p+"D", maze,row+1, col);
        if(col < maze[0].length-1)
            printPathsAllDirections(p+"R", maze, row, col+1);
        if(row > 0)
            printPathsAllDirections(p+"U", maze,row-1, col);
        if(col > 0)
            printPathsAllDirections(p+"L", maze, row, col-1);

        // this is the line where the function ends
        // So, revert back the changes made to the cell
        //(*** revert the change after finishing your work - Backtracking 2 ***)
        maze[row][col] = true;

    }

    public void allPathsPrint(String p, boolean[][] maze, int row, int col, int[][] pathArray, int step){
        //base condition
        if(row == maze.length-1 && col == maze[0].length-1){
            pathArray[row][col] = step;
            System.out.println(p);
            for (int[] arr : pathArray) {
                System.out.println(Arrays.toString(arr));
            }
            return;
        }

        //to handle obstacles
        if(!maze[row][col]){
            return;
        }

        //Marking current cell as false
        //(*** make a change before starting your work - Backtracking 1 ***)
        maze[row][col] = false;
        pathArray[row][col] = step;


        if(row < maze.length-1)
            allPathsPrint(p+"D", maze, row+1, col, pathArray, step+1);
        if(col < maze[0].length-1)
            allPathsPrint(p+"R", maze, row, col+1, pathArray, step+1);
        if(row > 0)
            allPathsPrint(p+"U", maze, row-1, col, pathArray, step+1);
        if(col > 0)
            allPathsPrint(p+"L", maze, row, col-1, pathArray, step+1);

        // this is the line where the function ends
        // So, revert back the changes made to the cell
        //(*** revert the change after finishing your work - Backtracking 2 ***)
        maze[row][col] = true;
        pathArray[row][col] = 0;

    }
}
