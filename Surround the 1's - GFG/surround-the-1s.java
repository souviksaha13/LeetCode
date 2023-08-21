//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix)
    {
        // code here
        int ans = 0;
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j]  == 0) continue;  // we only process 1's
                int cnt = 0;
                // left
                if(j>0) {
                    if(matrix[i][j-1] == 0) cnt++;
                }
                // right
                if(j<matrix[0].length-1) {
                    if(matrix[i][j+1] == 0) cnt++;
                }
                // up
                if(i>0) {
                    if(matrix[i-1][j] == 0) cnt++;
                }
                // down
                if(i<matrix.length-1) {
                    if(matrix[i+1][j] == 0) cnt++;
                }
                // up-left
                if(i>0 && j>0) {
                    if(matrix[i-1][j-1] == 0) cnt++;
                }
                // down-left
                if(i<matrix.length-1 && j>0) {
                    if(matrix[i+1][j-1] == 0) cnt++;
                }
                // up-right
                if(i>0 && j<matrix[0].length-1) {
                    if(matrix[i-1][j+1] == 0) cnt++;
                }
                // down-right
                if(i<matrix.length-1 && j<matrix[0].length-1) {
                    if(matrix[i+1][j+1] == 0) cnt++;
                }
                // check if cnt is even
                if(cnt == 2 || cnt == 4 || cnt == 6 || cnt == 8) ans++;
            }
        }
        return ans;
    }
}