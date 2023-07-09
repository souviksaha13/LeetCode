//{ Driver Code Starts
import java.util.*;
import java.io.*;


// } Driver Code Ends

class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        // Your code here
        
        for(int i=0; i<size; i++) {
            if(arr[i] > 0 && arr[i] <= size) {
                if(arr[arr[i]-1] == arr[i]) continue;
                int temp = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i--] = temp;
                // we put the element in the right place
                // ie if we encounter 1 -> we put it at index 0
            }
        }
        
        int ans = size+1;
        for(int i=0; i<size; i++) {
            if(arr[i] != i+1) {
                ans = i+1; 
                break;
            }
        }
        
        return ans;
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) throws IOException
    {

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		
        //taking testcases
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    
		    //input number n
			int n=Integer.parseInt(in.readLine().trim());
			int[] arr=new int[n];
			String s[]=in.readLine().trim().split(" ");
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(s[i]);
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			out.println(missing);
		}
		out.close();
    }
}


// } Driver Code Ends