class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        // pure dfs 
        // start from each node and keep on going in each direction till the number is greater than current number
        if(matrix != null && matrix.length == 0) return 0;
        int max = 0;
        int[][] visitedAlready = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                if(visitedAlready[i][j] == 0) {
                 visitedAlready[i][j] = dfs(matrix, i , j,  visitedAlready );
                }
                max = Math.max(visitedAlready[i][j], max);   
            }
        }
    return max ;
    }



    int dfs(int[][] matrix, int i, int j, int[][]visited) {
        if(i < 0 || j < 0 || i > matrix.length || j > matrix[0].length ) {
            return 0;
        }

        if(visited[i][j] != 0) return visited[i][j];
        int p = 0 ;
        
        int left = (j > 0 && matrix[i][j] < matrix[i][j-1])  ? dfs(matrix, i, j - 1, visited) : 0;
        int right = (j < matrix[0].length - 1 && matrix[i][j] < matrix[i][j+1]) ? dfs(matrix, i, j + 1, visited) : 0 ;
        int top = (i > 0 && matrix[i][j] < matrix[i-1][j])   ? dfs(matrix, i - 1, j , visited) : 0 ;
        int bottom = (i < matrix.length - 1 && matrix[i][j] < matrix[i+1][j]) ? dfs(matrix, i + 1, j, visited) : 0 ;
        
        //System.out.println("i: "+ i + " j : " + j +"left :"+ left + " right :"+right +" top: "+ top +" bottom : "+ bottom);
        p = Math.max(p,(Math.max(left,Math.max(right,Math.max(top,bottom)))));
        visited[i][j] = p + 1;
        //System.out.println("p :"+ p + " visited[i][j] :" + visited[i][j]);
        return p + 1;

    }
}