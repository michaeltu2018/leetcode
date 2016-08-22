public class Solution {
    int total = 0;
    public int numberOfPatterns(int m, int n) {
        boolean [][] v = new boolean[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                
                v[i][j] = true;
                dfs(v, i, j,m,n,1);
                v[i][j] = false;
            }
        }
        return total;
    }
    
    void dfs(boolean[][] v, int i, int j,int m, int n, int count){
        if(count>=m && count <=n){
            total ++;
        }
        if(count >= n){
            return;
        }
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                if( v[x][y]||(x==i && y==j) || ( (x+y == i+j)&& Math.abs(x-i)>1 && !v[1][1] ) || ((x==i) && Math.abs(y-j)>1 && !v[x][1]  ) || ((y==j) && Math.abs(x-i)>1 && !v[1][y]) || (Math.abs(x- y) == Math.abs(i-j)&&!v[1][1] && Math.abs(x-i) >1 ) ){
                    continue;
                }
                /*
                if(v[i][j] || (i==x && j==y) || (Math.abs(i-j) == Math.abs(x-y) && Math.abs(x-i)>1 && !v[1][1]) || (j==y && Math.abs(x-i)>1 && !v[1][j]) || (x==i && Math.abs(y-j)>1 && !v[i][1]) || ((x+y == i+j)&& Math.abs(x-i)>1 && !v[1][1]) ){
                    continue;
                }
                */
                v[x][y] = true;
                dfs(v, x, y, m,n,count+1);
                v[x][y] = false;
            }
        }
    }
}
