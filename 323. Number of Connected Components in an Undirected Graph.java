public class Solution {
    public int countComponents(int n, int[][] edges) {
        if(n==0){
            return 0;
        }
        int[] root = new int[n];
        for(int i = 0; i < n; i++) root[i] = i; 
        for(int[] edge : edges){
            int root1 = findRoot(root, edge[0]);
            int root2 = findRoot(root, edge[1]);
            if(root1 != root2){
                root[root2] = root1;
                n--;
            }
        }
        return n;
    }
    
    int findRoot(int[] root, int id){
        while(root[id] != id){
            root[id] = root[root[id]];
            id = root[id];
        }
        return id;
    }
}
