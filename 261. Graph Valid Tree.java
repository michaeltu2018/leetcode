public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] visited = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; ++i) { adjList.add(new ArrayList<Integer>()); }
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        if(hasCycle(-1, 0, visited, adjList)){
            return false;
        }
        for(int i=0;i<visited.length;i++){
            if(visited[i] == 0){
                return false;
            }
        }
        return true;
    }
    
    boolean hasCycle(int pred, int cur, int[] visited, List<List<Integer>> adjList){
            visited[cur] = 1;
            for(Integer x : adjList.get(cur)){
                if(x == pred) continue;
                if(visited[x] == 1){
                    return true;
                }
                else if(visited[x] == 0){
                    if(hasCycle(cur, x, visited, adjList)){
                        return true;
                    }
                }
            }
        
        //visited[cur] = 2;
        return false;
    }
}
