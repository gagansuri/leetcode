class Solution {
  public int numIslands(char[][] grid) {
    // check all the elements 
    // when you see a 1 - do a dfs and reach all the neighboring nodes
    // if the node is 1 set it to zero
    // all the ones in dfs are counted together as 1 island only
    int count = 0 ;
    for(int i = 0 ; i < grid.length; i++) {
        for(int j = 0 ; j < grid[i].length; j++) {
            // check if 1
            if(grid[i][j] == '1') {
                count++;
                dfs1(grid, i, j);
            }
        }
    }   
    return count;
  }


    void dfs1(char[][] grid, int row, int col) {
        // check if within bounds and not ! = 0
        if(row < 0 || row > grid.length - 1 || col < 0 || col >  grid[row].length - 1  || grid[row][col] == '0' ) {
            return;
        }
    // here row col are valid and equal to 1

    grid[row][col] = '0';
    dfs(grid, row - 1 , col);
    dfs(grid, row , col - 1);
    dfs(grid, row , col + 1);
    dfs(grid, row + 1 , col);
    }































































































    public int numIslands1(char[][] grid) {
        int count = 0 ; 
        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j < grid[0].length;j++) {
                //System.out.println(" i: "+i +" j: "+j +" grid[i][j]: "+grid[i][j]);
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid,i,j);
                }

            }
        }

        return count;
    }

    public void dfs(char[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row+1,col);
        dfs(grid, row-1,col);
        dfs(grid, row,col+1);
        dfs(grid, row,col-1);

    }
}