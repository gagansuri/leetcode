class Solution {
    public int getMaximumGold(int[][] grid) {
        // iterate over each element in the grid and check if the value is not zero
        int max = 0 ;
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
                if(grid[i][j] != 0) {
                    int gold = findGoldFromPath(grid, i , j, new boolean[grid.length][grid[0].length]);
                    max = Math.max(max, gold);
                }
         }
        }
        return max;
    }

    int findGoldFromPath(int[][]grid, int row , int col, boolean[][] visited) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length ||
            grid[row][col] == 0 || visited[row][col] == true) {
                return 0;
            }
        visited[row][col] = true;
        int up      =  findGoldFromPath(grid, row - 1 , col, visited); //up
        int down    =  findGoldFromPath(grid, row + 1 , col, visited); // down
        int left    =  findGoldFromPath(grid, row , col - 1, visited);// left
        int right   =  findGoldFromPath(grid, row , col + 1, visited);//right
        visited[row][col] = false;
        int max = Math.max(up, Math.max(down,Math.max(left,right))) +  grid[row][col];
        return max;      
    }
}