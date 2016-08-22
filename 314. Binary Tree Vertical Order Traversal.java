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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(null == root){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        q.offer(root);
        cols.offer(0);
        int min = 0;
        int max = 0;
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            Integer curCol = cols.poll();
            if(!map.containsKey(curCol)){
                map.put(curCol, new ArrayList<>());
            }
            map.get(curCol).add(cur.val);
            max = Math.max(max, curCol);
            min = Math.min(min, curCol);
            if(cur.left != null){
                q.offer(cur.left);
                cols.offer(curCol-1);
            }
            if(cur.right != null){
                q.offer(cur.right);
                cols.offer(curCol+1);
            }
        }
        for(int i=min;i<=max;i++){
            res.add(map.get(i));
        }
        return res;
    }
}
