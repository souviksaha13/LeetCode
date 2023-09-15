//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    int equalPartition(int N, int arr[])
    {
        // code here
        int sum = 0;
        for(int el : arr) {
            sum += el;
        }
        
        if(sum % 2 != 0) return 0;
        
        int[][] dp = new int[N][sum/2+1];
        
        for(int i=0; i<N; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        if(rec(arr, dp, sum/2, 0) == 1) return 1;
        
        return 0;
    }
    
    int rec(int[] arr, int[][] dp, int tar, int idx) {
        if(idx == arr.length) return 0;
        if(tar == 0) return 1;
        if(dp[idx][tar] != -1) return dp[idx][tar];
        
        int pick = 0;
        
        if(tar-arr[idx] >= 0) pick = rec(arr, dp, tar-arr[idx], idx+1);
        int notPick = rec(arr, dp, tar, idx+1);
        
        if(pick == 1 || notPick == 1) dp[idx][tar] = 1;
        else dp[idx][tar] = 0;
        
        return dp[idx][tar];
    }
}