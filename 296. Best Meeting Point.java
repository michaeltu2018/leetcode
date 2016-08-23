public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> x = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    x.add(i);
                    //y.add(j);
                }
            }
        }
        
        for(int j=0;j<grid[0].length;j++){
            for(int i=0;i<grid.length;i++){
                if(grid[i][j] == 1){
                    //x.add(i);
                    y.add(j);
                }
            }
        }
        return getMedianDistance(x) + getMedianDistance(y);
    }
    
    int getMedianDistance(List<Integer> list){
        //Collections.sort(list);
        int i=0;
        int j= list.size()-1;
        int res = 0;
        while(i<j){
            res += (list.get(j) - list.get(i));
            j--;
            i++;
        }
        return res;
    }
}
