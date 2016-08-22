/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root);
        return max;
    }
    
    Data helper(TreeNode root){
        Data res = new Data();
        if(root == null){
            res.isBST = true;
            return res;
        }
        Data left = helper(root.left);
        Data right = helper(root.right);
        res.min = Math.min(root.val, Math.min(left.min, right.min));
        res.max = Math.max(root.val, Math.max(left.max, right.max));
        if(left.isBST && right.isBST && root.val > left.max && root.val < right.min){
            res.isBST = true;
            res.size = left.size + right.size + 1;
            max = Math.max(max, res.size);
        }
        else{
            res.size = 0;
        }
        return res;
    }

}

class Data{
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int size;
    boolean isBST;
    public Data(){
        isBST = false;
    }
}

