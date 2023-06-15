//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String s){
       if (s == null || s.length() < 2) {
            return s;
        }
        
        int start = 0; // Starting index of the longest palindromic substring
        int maxLength = 1; // Length of the longest palindromic substring
        
        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes with current character as center
            int len1 = expandAroundCenter(s, i, i);
            // Check for even-length palindromes with current and next character as center
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int len = Math.max(len1, len2); // Length of the longest palindromic substring centered at i
            
            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    // Helper method to expand around the center and find the length of a palindromic substring
    private static int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        
        return R - L - 1;
    }
        
    
}