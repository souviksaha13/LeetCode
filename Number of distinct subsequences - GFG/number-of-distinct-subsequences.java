//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int distinctSubsequences(String S) {
        // code here
        // to keep track of the occurence of each character in a given position
        int[] last = new int[26];
        Arrays.fill(last, -1);
        
        int mod = 1000000007;
        int n = S.length();
        
        int[] dp = new int[n+1];
        
        // Empty substring has only one subsequence
        dp[0] = 1;
        
        for(int i=1; i<=n; i++) {
            dp[i] = 2*dp[i-1];
            dp[i] %= mod;
            
            // if current character has appeared before ->
            //      then remove all subsequences ending  with previous occurence
            
            if(last[S.charAt(i-1)-'a'] != -1) {
                dp[i] = (dp[i] - dp[last[S.charAt(i-1)-'a']]+mod) % mod;
                // + mod is done to handle the cases where the values of dp[i] may be less 
                //  because of the %mod done above
            }
            
            // mark occurence of the current character
            last[S.charAt(i-1)-'a'] = (i-1);
        }
        
        return dp[n];
    }
}