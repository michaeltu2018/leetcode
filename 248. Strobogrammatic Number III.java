public class Solution {
    char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    int count = 0;
    public int strobogrammaticInRange(String low, String high) {
        for(int i=low.length();i<=high.length();i++){
            dfs(new char[i],low,high,0,i-1);
        }
        return count;
    }
    
    void dfs(char[] c, String low, String high, int l, int r){
        if(l > r){
            String cand = new String(c);
            if((cand.length() == low.length() && cand.compareTo(low) < 0) || (cand.length() == high.length() && cand.compareTo(high) > 0)){
                return;
            }
            count++;
            return;
        }

        for(char[] pair : pairs){
                c[l] = pair[0];
                c[r] = pair[1];
                if(c[0] == '0' && c.length!=1) continue;
                if(l < r) dfs(c,low,high,l+1,r-1);
                if(l == r && pair[0] == pair[1]){
                    dfs(c,low,high,l+1,r-1);
                }
        }
        
        
    }
}
