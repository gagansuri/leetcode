class Solution {
    public void rotate(int[][] matrix) {
        //transpose - rows to col and then reverse
        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = i+1 ; j < matrix[0].length; j++) {
                if(i != j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp; 
            }
        }
        }
    // reverse left to right
    for(int i = 0 ; i < matrix.length; i++) {
        int start = 0, end = matrix[0].length - 1;
        while(start < end) {
            int temp = matrix[i][start];
            matrix[i][start] = matrix[i][end];
            matrix[i][end] = temp;
            start++;
            end--;
        }
    }
    }   
}