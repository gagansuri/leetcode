class Solution {
    public int getMaximumGold(int[][] grid) {
    if(grid == null || grid.length == 0) return 0;
    int rows = grid.length, columns = grid[0].length;
    boolean[][] seen = new boolean[rows][columns];
    int max = 0;

    // only start the search from elements which dont have a zero
    for(int i = 0 ; i < rows; i ++) {
        for(int j = 0 ; j < columns; j++) {
            if(grid[i][j] != 0) {
                int gold = dfs(grid, i , j, seen);
                max = Math.max(gold,max);
            }
        }
    }
    return max;
    }


    int dfs(int[][] grid, int row, int col, boolean[][] seen) {
        // first check boundaries
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0 || seen[row][col] == true ) {
            return 0;
        }
        seen[row][col] = true;
        int left = dfs(grid, row, col - 1, seen);
        int right = dfs(grid, row, col + 1, seen);
        int up = dfs(grid, row - 1, col, seen);
        int down = dfs(grid, row +1, col, seen);
        seen[row][col] = false;
        return Math.max(left, Math.max(right, Math.max(up,down))) + grid[row][col];

    }
}