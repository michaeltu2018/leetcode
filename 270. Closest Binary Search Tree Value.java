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
    int res;
    double diff = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        if(root == null){
            return res;
        }
        double currDiff = Math.abs((double)root.val-target);
        if(currDiff<diff){
            res = root.val;
            diff = currDiff;
        }
        if(root.val < target){
            return closestValue(root.right, target);
        }
        else{
            return closestValue(root.left, target);
        }
    }
}
