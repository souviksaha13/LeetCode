//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
	public:
		string FirstNonRepeating(string A){
	    vector<int> freq(26);
	    queue<char> q;
	    string temp;
	    
	    for(auto ch: A) {
	        q.push(ch);
	        freq[ch - 'a']++;
	        
	        while(!q.empty() and freq[q.front() - 'a'] > 1)
	            q.pop();
	        
	        if(q.size() == 0)
	            temp += '#';
	        else
	            temp += q.front();
	    }
	    
	    return temp;
	}

};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string A;
		cin >> A;
		Solution obj;
		string ans = obj.FirstNonRepeating(A);
		cout << ans << "\n";
	}
	return 0;
}
// } Driver Code Ends