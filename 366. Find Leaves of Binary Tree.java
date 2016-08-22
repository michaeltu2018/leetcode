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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    int helper(TreeNode node, List<List<Integer>> list){
        if(node == null) return -1;
        int leftLevel = helper(node.left, list);
        int rightLevel = helper(node.right, list);
        int curLevel = Math.max(leftLevel, rightLevel) + 1;
        if(curLevel >= list.size()){
            list.add(new ArrayList<>());
        }
        list.get(curLevel).add(node.val);
        return curLevel;
    }
    
}
