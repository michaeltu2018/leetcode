public class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if(n==0){
            return 0;
        }
        int[] red = new int[n];
        int[] green = new int[n];
        int[] blue = new int[n];
        red[0] = costs[0][0];
        green[0] = costs[0][1];
        blue[0] = costs[0][2];
        for(int i=1;i<n;i++){
            red[i] = Math.min(green[i-1], blue[i-1]) + costs[i][0];
            green[i] = Math.min(red[i-1], blue[i-1]) + costs[i][1];
            blue[i] = Math.min(red[i-1], green[i-1]) + costs[i][2];
        }
        return Math.min(Math.min(red[n-1], green[n-1]),blue[n-1]);
    }
}
