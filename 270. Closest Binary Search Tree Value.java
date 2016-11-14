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

// iterative
public int closestValue(TreeNode root, double target) {
        TreeNode greater = null;
        TreeNode smaller = null;
        while(root != null) {
            if(root.val == target) {
                return root.val;
            } else if(root.val < target) {
                smaller = root;
                root = root.right;
            } else {
                greater = root;
                root = root.left;
            }
        }
        if(greater == null) {
            return smaller.val;
        }
        if(smaller == null) {
            return greater.val;
        }
        return (greater.val - target) < (target - smaller.val) ? greater.val : smaller.val;
    }
