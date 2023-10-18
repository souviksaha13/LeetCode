//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        boolean[] vis = new boolean[V];
        boolean[] pathvis = new boolean[V];
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<V; i++) {
            if(!vis[i]) {
                dfs(adj, i, vis, pathvis, ans);
            }
        }
        
        Collections.sort(ans);
        
        return ans;
    }
    
    boolean dfs(List<List<Integer>> adj, int src, boolean[] vis, boolean[] pathvis, List<Integer> ans) {
        vis[src] = true;
        pathvis[src] = true;
        
        for(Integer el : adj.get(src)) {
            // if the element is never visited earlier
            if(!vis[el]) {
                boolean check = dfs(adj, el, vis, pathvis, ans);
                if(check) return true;
            }
            // else if the element is also path visited
            else if(pathvis[el]) return true;
        }
        
        ans.add(src);
        pathvis[src] = false;
        
        return false;
    }
}