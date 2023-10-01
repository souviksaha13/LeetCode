//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    // Function to find the maximum money the thief can get.
    public int FindMaxSum(int[] arr, int n)
    {
        int prevMax = 0; // Maximum money stolen from the previous house
        int currMax = arr[0]; // Maximum money stolen from the current house
        
        for (int i = 1; i < n; i++)
        {
            int temp = currMax;
            currMax = Math.max(currMax, prevMax + arr[i]);
            prevMax = temp;
        }
        
        return currMax;
    }
}