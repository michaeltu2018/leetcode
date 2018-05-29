/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
time: O(n)
space: O(k)

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



Analysis:
The time complexity would be O(k + k * logk). 
Space complexity is O(k).

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
         
        Stack<Integer> precedessor = new Stack<>();
        Stack<Integer> successor = new Stack<>();
         
        getPredecessor(root, target, precedessor, k);
        getSuccessor(root, target, successor, k);
         
        for (int i = 0; i < k; i++) {
            if (precedessor.isEmpty()) {
                result.add(successor.pop());
            } else if (successor.isEmpty()) {
                result.add(precedessor.pop());
            } else if (Math.abs((double) precedessor.peek() - target) < Math.abs((double) successor.peek() - target)) {
                result.add(precedessor.pop());
            } else {
                result.add(successor.pop());
            }
        }
         
        return result;
    }
     
    //time: O(k)
    private void getPredecessor(TreeNode root, double target, Stack<Integer> precedessor, int k) {
        if (root == null) {
            return;
        }
         
        getPredecessor(root.left, target, precedessor, k);
         
        if (root.val > target || precedessor.size() >= k) {
            return;
        }
         
        precedessor.push(root.val);
         
        getPredecessor(root.right, target, precedessor, k);
    }
     
    //time: O(k)
    private void getSuccessor(TreeNode root, double target, Stack<Integer> successor, int k) {
        if (root == null) {
            return;
        }
         
        getSuccessor(root.right, target, successor, k);
         
        if (root.val <= target || successor.size() >= k) {
            return;
        }
         
        successor.push(root.val);
         
        getSuccessor(root.left, target, successor, k);
    }
}
