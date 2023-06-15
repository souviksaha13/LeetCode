/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        int ansLevel = 1;   // initializing the ans as 1, ie the 1st level
        long maxSum = root.val;  // initializing the maxSum as the sum of the 1st level, ie the root.val
        int level = 1;   // keeps the count of the levels 

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int nodes = q.size();  // no. of nodes in that particular level
            long sum = 0;    // calculates the sum of the node values of that level
            for(int i=0; i<nodes; i++) {
                TreeNode temp = q.poll();
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
                sum += temp.val;
            }

            if(sum > maxSum) {
                maxSum = sum;
                ansLevel = level;
            }
            level++;
        }
        return ansLevel;
    }
}