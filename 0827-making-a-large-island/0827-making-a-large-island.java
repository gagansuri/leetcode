class Solution {
    
public int largestIsland(int[][] grid) {
    // first find the size of islands
    // save the size of islands in a map - key value - island id : count
    // go over each one of the items in the grid if 0 then calculate the count from left right top and bottom
    int islandId = 2;int max = 0 ;
    Map<Integer,Integer> map = new HashMap<>();
    for(int i = 0 ; i < grid.length; i++) {
        for(int j = 0 ; j < grid[0].length; j++) {
            if(grid[i][j] == 1) {
                int size = dfsI(grid, i, j , islandId);
                map.put(islandId, size);
                islandId++;
                max = Math.max(max,size);
            }
        }
    }

    // iterate over the grid again and make one of the zero as one and calculate the neighbors
    for(int i = 0 ; i < grid.length; i++) {
        for(int j = 0 ; j < grid[0].length; j++) {
            if(grid[i][j] == 0) {
                //get the left right top and bottom ids
                
                /*
                int left = j > 0 ? grid[i][j-1] : 0;
                int right = j < grid[0].length - 1 ? grid[i][j+1] : 0;
                int top = i > 0 ? grid[i-1][j] : 0 ;
                int bottom = i > grid.length  ? grid[i-1][j] : 0;
*/
                int top = i > 0 ? grid[i-1][j] : 0 ;
                int bottom = i > grid.length - 1 ?  0 : grid[i+1][j] ;
                int left = j > 0 ? grid[i][j-1] : 0 ;
                int right = j < grid[0].length - 1 ? grid[i][j + 1] : 0 ;

                
                Set<Integer> unique = new HashSet<>();
                unique.add(left); unique.add(right); unique.add(top);unique.add(bottom);
                int sum = 0 ;
                for(int id : unique) {
                    if(id != 0)
                    sum += map.get(id); 
                } 
              
                max = Math.max(sum+1, max);
            }
        }
    }


    //System.out.println(map);
    return max;
}


  private int dfsI(int[][]grid, int row, int col , int islandId) {
    if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) 
        return 0;

    grid[row][col] = islandId;
    int left    = dfsI(grid, row, col - 1, islandId);
    int right   = dfsI(grid, row, col + 1, islandId);
    int up      = dfsI(grid, row - 1, col, islandId);
    int down    = dfsI(grid, row + 1, col, islandId);
    return left + right + up + down + 1;
 }




public int largestIslandB(int[][] grid) {
    // first find the size of islands
    // save the size of islands in a map - key value - island id : count
    // go over each one of the items in the grid if 0 then calculate the count from left right top and bottom

    Map<Integer, Integer> islandIdCountMap = new HashMap<>();
    int max = 0;
    int islandId = 2; // 1 and 0 are reserved for water and land

    for(int i = 0 ; i < grid.length; i++) {
        for(int j = 0 ; j < grid[i].length ; j++) {
            if(grid[i][j] == 1) {
                int islandCount = dfs1(grid, i , j , islandId) ;
                islandIdCountMap.put(islandId++, islandCount);
                max = Math.max(max,islandCount);
            }
        }
    }

    // now we have a map like this islandId : size
    // 2 : 2, 3 : 2 and so on
    for(int i = 0 ; i < grid.length; i++) {
        for(int j = 0 ; j < grid[i].length ; j++) {
            if(grid[i][j] == 0) {
                // check the top left right and bottom
                int top = i > 0 ? grid[i-1][j] : 0 ;
                int bottom = i < grid.length - 1 ? grid[i+1][j] : 0 ;
                int left = j > 0 ? grid[i][j-1] : 0 ;
                int right = j < grid[0].length - 1 ? grid[i][j + 1] : 0 ;

                Set<Integer> unique = new HashSet<>();
                unique.add(top);
                unique.add(bottom);
                unique.add(left);
                unique.add(right);
                int sum = 0 ;
                for(int k : unique) {
                    if(k != 0) {
                        sum += islandIdCountMap.get(k);
                    }
                }

                max = Math.max(sum+1, max);

            }
        }
    }  

    return max;
}    
    
int dfs1(int[][]grid, int row , int col , int isLandId) {
    
    if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1) {
        return 0;
    }
    grid[row][col] = isLandId;
    int left = dfs(grid, row, col - 1 , isLandId);
    int right = dfs(grid, row, col + 1 , isLandId);
    int top = dfs(grid, row -1 , col  , isLandId);
    int bottom = dfs(grid, row + 1, col , isLandId);

    return left + right + top + bottom + 1;


}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public int largestIsland1(int[][] grid) {
        // first count the size of islands
        // give each one an id and count - map - islandId - count
        // keep a max of the size so far

        if(grid == null || grid.length == 0) return 0;

        int max = 0, islandId = 2, count = 0, m = grid.length, n = grid[0].length ;
        Map<Integer, Integer> islandIdSizeMap = new HashMap<>();
        for(int i = 0; i < m ; i++) {
            for( int j = 0 ; j < grid[0].length ; j++) {
                if(grid[i][j] == 1) {
                    count = dfs(grid, i , j , islandId);
                    islandIdSizeMap.put(islandId++, count);
                    max = Math.max(count, max);
                }
            }
        }
    //System.out.println(max);
    //System.out.println(islandIdSizeMap);

    for(int i = 0; i < m ; i++) {
            for( int j = 0 ; j < grid[0].length ; j++) {
                if(grid[i][j] == 0) {
                    int top = i > 0 ? grid[i-1][j] : 0;
                    int bottom = i < grid.length - 1 ? grid[i+1][j] : 0;
                    int left = j > 0 ? grid[i][j-1] : 0 ;
                    int right = j < grid[i].length - 1 ? grid[i][j + 1] : 0;
                    int sum = 0 ;
                    Set<Integer> uniqueIslands = new HashSet<>();
                    uniqueIslands.add(top);
                    uniqueIslands.add(left);
                    uniqueIslands.add(right);
                    uniqueIslands.add(bottom);
                    for(int p : uniqueIslands) {
                        //System.out.print(n +" ");
                        if(p != 0) {
                             sum += islandIdSizeMap.get(p);
                        }
                    }
                    sum++;
                    max = Math.max(sum, max);

                }
            }
    }

    return max;
    }
    int dfs(int[][] grid, int row, int col, int isLandId) {
            if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1) {
                return 0;
            }

            grid[row][col] = isLandId;
            int left    = dfs(grid, row , col - 1, isLandId);
            int right   = dfs(grid, row , col + 1, isLandId);
            int top     = dfs(grid, row - 1, col, isLandId);
            int bottom  = dfs(grid, row + 1, col, isLandId);
            return left + right + top + bottom + 1;
        }
    
}