public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int rowCache = 0;
        int max = 0;
        int[] colCache = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0 || grid[i][j-1] == 'W'){
                    rowCache = countEnemyInRow(grid, i, j);
                }
                if(i==0 || grid[i-1][j] == 'W'){
                    colCache[j] = countEnemyInCol(grid, i, j);
                }
                if(grid[i][j] == '0'){
                    max = Math.max(max, rowCache + colCache[j]);
                }
            }
        }
        return max;
    }
    
    int countEnemyInRow(char[][] grid, int i, int j){
        int count = 0;
        while(j<grid[0].length && grid[i][j] != 'W'){
            if(grid[i][j] == 'E'){
                count++;
            }
            j++;
        }
        return count;
    }
    
    int countEnemyInCol(char[][] grid, int i, int j){
        int count = 0;
        while(i<grid.length && grid[i][j] != 'W'){
            if(grid[i][j] == 'E'){
                count++;
            }
            i++;
        }
        return count;
    }
}
