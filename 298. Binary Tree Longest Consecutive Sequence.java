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
    int result = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root,root.val,0);
        return result;
    }
    
    void helper(TreeNode root, int target, int cur){
        if(root == null){
            return;
        }
        if(root.val == target){
            cur++;
            result = Math.max(cur, result);
        }
        else{
            cur = 1;
        }
        helper(root.left, root.val+1, cur);
        helper(root.right, root.val+1, cur);
    }
}
