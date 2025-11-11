class Solution {
  public int numIslands(char[][] grid) {
    int count = 0 ;
    for(int i = 0 ; i < grid.length; i++) {
        for(int j = 0 ; j < grid[i].length; j++) {
            if(grid[i][j] == '1') {
                count++;
                dfs(grid, i , j);
            }
        }
    }
    return count;
  }
  void dfs(char[][] grid, int row, int col) {

    if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
        return;
    }

    grid[row][col] = '0';

    // all connecting to be counted as with the original and should be set to 0
    //left
   dfs(grid, row, col - 1);
   // right
   dfs(grid, row, col + 1);
   //up
   dfs(grid, row - 1, col);
   // down
   dfs(grid, row + 1, col);


  }
  }