//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static long mod = 1000000007;
    static int nthFibonacci(int n){
        // code here
        long a = 1, b = 1;
        
        for(int i=3; i<=n; i++) {
            a = (a+b);
            b = (a-b);
            a = a%mod;
            b = b%mod;
        }
        
        return (int)(a%mod);
    }
}