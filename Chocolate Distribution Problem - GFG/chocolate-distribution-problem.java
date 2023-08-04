//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0;i<n;i++)
                {
                    int x = sc.nextInt();
                    arr.add(x);
                }
            int m = sc.nextInt();
            
            Solution ob = new Solution();
            
    		System.out.println(ob.findMinDiff(arr,n,m));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long findMinDiff (ArrayList<Integer> arr, int n, int m)
    {
        // your code here
        int ans = Integer.MAX_VALUE;
        Collections.sort(arr);
        int lo = 0, hi = m-1;
        
        do {
            ans = Math.min(ans, (arr.get(hi)-arr.get(lo)));
            hi++; lo++;
        } while(hi < n);
        
        return ans;
    }
}