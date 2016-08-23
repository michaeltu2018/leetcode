public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder.length == 0 ||preorder.length == 1 ){
            return true;
        }
        return helper(preorder, 0 , preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    boolean helper(int[] preorder, int start, int end, int min, int max){
        if(start > end){
            return true;
        }
        int pivot = preorder[start];
        int pointer = start;

        if(pivot > max || pivot < min){
            return false;
        }
        while(pointer <= end && preorder[pointer] <= pivot ){
            pointer++;
        }
        int tmp = pointer;
        return helper(preorder, start+1, tmp-1,min, pivot)&&helper(preorder, tmp, end,pivot,max);
        
    }
}
