public class Solution {
    final int N = 26;
    public String alienOrder(String[] words) {
        if(words.length == 0){
            return "";
        }
        int[] indegree = new int[N];
        Arrays.fill(indegree,-1);
        List<Set<Integer>> graph =  new ArrayList<Set<Integer>>();
        buildGraph(words,graph, indegree);
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!q.isEmpty()){
            Integer cur = q.poll();
            sb.append((char)('a' + cur));
            for(Integer x : graph.get(cur)){
                indegree[x] --;
                if(indegree[x] == 0){
                    q.add(x);
                }
            }
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] > 0){
                return "";
            }
        }
        return sb.toString();
    }

    void buildGraph(String[] words, List<Set<Integer>> list, int[] indegree){
        for(int i=0;i<26;i++){
            list.add(new HashSet<Integer>());
        }
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                char c = words[i].charAt(j);
                if(indegree[c-'a'] == -1){
                    indegree[c-'a'] = 0;
                }
            }
            if(i == 0) continue;
            for(int k=0;k<Math.min(words[i].length(), words[i-1].length());k++){
                char c1 = words[i-1].charAt(k);
                char c2 = words[i].charAt(k);
                if(c1 != c2){
                    if(!list.get(c1-'a').contains(c2-'a')){
                        list.get(c1-'a').add(c2-'a');
                        indegree[c2-'a']++;
                    }
                    break;
                }
            }
        }
    }
}
