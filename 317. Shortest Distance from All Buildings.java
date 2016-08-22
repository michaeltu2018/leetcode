public class Solution {
    int m;
    int n;
    public int shortestDistance(int[][] grid) {
        m = grid.length;
        if(m == 0){
            return -1;
        }
        n = grid[0].length;
        int[][] dist = new int[m][n];
        int[][] visitNum = new int[m][n];
        int buildingCount = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    buildingCount++;
                    bfs(grid,i,j,dist,visitNum);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0 && visitNum[i][j] == buildingCount){
                    res = Math.min(dist[i][j], res);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    void bfs(int[][] grid, int i, int j, int[][] dist, int[][] visitNum){
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new int[]{i,j});
        int distance = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0;k<size;k++){
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                
                visitNum[x][y]++;
                dist[x][y] += distance;
                if(x>0 && !visited[x-1][y] && grid[x-1][y] == 0){
                    q.offer(new int[]{x-1,y});
                    visited[x-1][y] = true;
                }
                if(x<m-1 && !visited[x+1][y] && grid[x+1][y] == 0){
                    q.offer(new int[]{x+1,y});
                    visited[x+1][y] = true;
                }
                if(y>0 && !visited[x][y-1]  && grid[x][y-1] == 0){
                    q.offer(new int[]{x,y-1});
                    visited[x][y-1] = true;
                }
                if(y<n-1 && !visited[x][y+1]  && grid[x][y+1] == 0){
                    q.offer(new int[]{x,y+1});
                    visited[x][y+1] = true;
                }
            }
            distance++;
        }
    }
}
