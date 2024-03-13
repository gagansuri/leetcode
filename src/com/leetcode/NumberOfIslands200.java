package com.leetcode;

public class NumberOfIslands200 {
    public static void main(String[] args) {
        char[][] grid =  {{'1','1','1','1','0'},
                          {'1','1','0','1','0'},
                          {'1','1','0','0','0'},
                          {'0','0','0','0','0'}};
        char[][] grid1 =
                        {{'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}};
        System.out.println(countIslands(grid));
        System.out.println(countIslands(grid1));
    }
    static int countIslands(char[][] grid) {
        int count = 0 ;
        for(int i = 0; i <grid.length; i++) {
            for(int j = 0; j <grid[0].length;j++) {
                if(grid[i][j]=='1') {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    static void dfs(char[][]grid, int i , int j) {
        if( i < 0
            || j < 0
            || i >= grid.length
            || j >= grid[0].length
            || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
