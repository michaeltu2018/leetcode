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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> list = new LinkedList<Integer>();
        helper(list,root,target,k);
        return list;
    }
    
    void helper(List<Integer> list, TreeNode root, double target, int k){
        if(root == null) return;
        helper(list, root.left, target, k);
        if(list.size() < k){
            list.add(root.val);
        }
        else if(Math.abs(list.get(0) - target) > Math.abs(root.val - target)){
            list.remove(0);
            list.add(root.val);
        }
        helper(list, root.right, target, k);
    }
    
}
