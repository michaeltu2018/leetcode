public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int topIndex =-1;
        int min = Integer.MIN_VALUE;
        for(int num: preorder){
            if(num < min){
                return false;
            }
            while(topIndex>=0 && num>preorder[topIndex]){
                min = preorder[topIndex--];
            }
            preorder[++topIndex] = num;
        }
        return true;
    }
}
