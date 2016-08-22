public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int am = A.length;
        int an = A[0].length;
        int bm = B.length;
        int bn = B[0].length;
        //assume an == bm
        int[][] res = new int[am][bn];
        for(int i=0;i<am;i++){
            for(int j=0;j<an;j++){
                if(A[i][j] == 0) continue;
                for (int k = 0; k < bn; k++) {
                    if(B[j][k] == 0) continue;
                    res[i][k] += A[i][j]*B[j][k];
                }
            }
        }
        return res;
    }
}
