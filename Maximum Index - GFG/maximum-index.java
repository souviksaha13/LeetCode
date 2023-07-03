//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
        int ans = -1;
        
        int[] mini = new int[n];
        int[] maxi = new int[n];
        
        mini[0] = arr[0];
        maxi[n-1] = arr[n-1];
        
        for(int i=1; i<n; i++) {
            mini[i] = Math.min(mini[i-1], arr[i]);
            maxi[n-i-1] = Math.max(maxi[n-i], arr[n-i-1]);
        }
        
        int i=0, j=0;
        while(i<n && j<n) {
            if(mini[i] <= maxi[j]) {
                ans = Math.max(ans, j-i);
                j++;
            }
            else i++;
        }
        
        
        return ans;
    }
}