public class Solution {
    public int numWays(int n, int k) {
        int[] dp = {0,k,k*k,0};
        if(n<=2){
            return dp[n];
        }
        int diff = k*(k-1);
        int same = k;
        int cur = -1;
        for(int i=2;i<n;i++){
            int prevDiff = diff;
            cur = diff*k + same*(k-1);
            diff = (diff + same)*(k-1);
            same = prevDiff;
        }
        return cur;
    }
}
