public class Solution {
    public boolean isReflected(int[][] points) {
        if(points.length <= 1) return true;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();
        for(int[] p : points){
            min = Math.min(p[0],min);
            max = Math.max(p[0],max);
            set.add(p[0] + "a" + p[1]);
        }
        if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE){
            return false;
        }
        int sum = min + max;

        for(int[] p : points){
            if(!set.contains((sum-p[0]) + "a" + p[1])){
                return false;
            }
        }
        
        return true;
    }
}
