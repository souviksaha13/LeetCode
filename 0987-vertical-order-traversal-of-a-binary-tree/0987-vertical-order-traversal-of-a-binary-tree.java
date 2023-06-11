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

    class Tuple {
        TreeNode node;
        int ver;
        int lev;

        public Tuple(TreeNode node, int ver, int lev) {
            this.node = node;
            this.ver = ver;
            this.lev = lev;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        // Created a DS to store the <vertical, level from top, and the values at that position>
        Queue<Tuple> q = new LinkedList<>();
        // This queue is created to traverse through the tree

        q.offer(new Tuple(root, 0, 0));

        while(!q.isEmpty()) {
            Tuple tup = q.poll();
            TreeNode node = tup.node;
            int ver = tup.ver;
            int lev = tup.lev;

            if(!mp.containsKey(ver)) mp.put(ver, new TreeMap<>());
            if(!mp.get(ver).containsKey(lev)) mp.get(ver).put(lev, new PriorityQueue<>());

            mp.get(ver).get(lev).offer(node.val);

            if(node.left != null) q.offer(new Tuple(node.left, ver-1, lev+1));
            if(node.right != null) q.offer(new Tuple(node.right, ver+1, lev+1));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer, PriorityQueue<Integer>> level : mp.values()) {
            List<Integer> ls = new ArrayList<>();
            for(PriorityQueue<Integer> vals : level.values()) {
                while(!vals.isEmpty()) {
                    ls.add(vals.poll());
                }
            }
            ans.add(new ArrayList<>(ls));
        }

        return ans;
    }
}