public class Solution {
    char[][] image;
    public int minArea(char[][] image, int x, int y) {
        this.image = image;
        int m = image.length;
        int n = image[0].length;
        int left = searchCol(0,y,0,m,true);
        int right = searchCol(y+1,n,0,m,false);
        int top = searchRow(0,x,0,n,true);
        int bot = searchRow(x+1,m,0,n,false);
        return (right-left)*(bot-top);
    }
    
    int searchCol(int i, int j, int top, int bottom, boolean opt){
        while(i<j){
            int mid = i + (j-i)/2;
            int r = top;
            while(r<bottom && image[r][mid] == '0') r++;
            if((r<bottom)==opt){
                j=mid;
            }
            else{
                i=mid+1;
            }
        }
        return i;
    }
    
    int searchRow(int i, int j, int left, int right, boolean opt){
        while(i<j){
            int mid = i+(j-i)/2;
            int c = left;
            while(c<right && image[mid][c] == '0') c++;
            if((c<right)==opt){
                j=mid;
            }
            else{
                i=mid+1;
            }
        }
        return i;
    }
}
