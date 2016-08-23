public class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int numOfIslands = 0;
        int[] root = new int[m*n];
        Arrays.fill(root, -1);
        for(int[] position : positions){
            int x = position[0];
            int y = position[1];
            int inx = x*n + y;
            root[inx] = inx;
            numOfIslands++;
            for(int[] dir : dirs){
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    int newInx = newX*n + newY;
                    if(newX < 0 || newX >= m || newY < 0 || newY >= n || root[newInx] == -1){
                        continue;
                    }
                    int newRoot = findRoot(newInx, root);
                    if(inx != newRoot){
                        root[inx] = newRoot;
                        numOfIslands--;
                        inx = newRoot;
                    }
                
            }
            res.add(numOfIslands);
        }
        return res;
    }
    
    int findRoot(int id, int[] root){
        while(id != root[id]){
            id = root[id];
            root[id] = root[root[id]];
        }
        return id;
    }
}
