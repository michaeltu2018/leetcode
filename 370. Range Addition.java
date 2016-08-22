public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] curr : updates){
            res[curr[0]] += curr[2];
            if(curr[1] < length-1){
                res[curr[1]+1] -= curr[2];
            }
        }
        for(int i=1;i<res.length;i++){
            res[i] += res[i-1];
        }
        return res;
    }
}
