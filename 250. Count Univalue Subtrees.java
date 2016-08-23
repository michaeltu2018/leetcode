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
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return count;
    }
    
    boolean helper(TreeNode root){
        if(root == null){
            return true;
        }
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if(left&&right){
            if((root.left==null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)){
                count++;
                return true;
            }
            return false;
        }
        return false;
    }
}
