//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
	vector<vector<int>>dir = { {0,1},{1,0} , {-1,0} , {0,-1} , {1,1} , {-1,-1} , {1,-1} , {-1,1} };
    int n,m;
    bool solve(int i,int j ,vector<vector<char>>&grid, string& word){
        for(auto x : dir){
            int dx = x[0];
            int dy = x[1];
            int k=0;
            for( ;k<word.length();k++){
                int new_x = i + dx*k;
                int new_y = j + dy*k;
                if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= m ) break;
                if(grid[new_x][new_y] != word[k]) break;
            }
            if(k==word.size()) return true;
        }
       return false;
    }
    
    vector<vector<int>>searchWord(vector<vector<char>>grid, string word){
        n = grid.size();
        m = grid[0].size();
        vector<vector<int>>ans;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] != word[0]) continue;
                if(solve(i,j,grid,word)) ans.push_back({i,j});
            }
        }
      return ans;
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, m;
		cin >> n >> m;
		vector<vector<char>>grid(n, vector<char>(m,'x'));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++)
				cin >> grid[i][j];
		}
		string word;
		cin >> word;
		Solution obj;
		vector<vector<int>>ans = obj.searchWord(grid, word);
		if(ans.size() == 0)
		{
		    cout<<"-1\n";
		}
		else
		{
		    for(auto i: ans){
			for(auto j: i)
				cout << j << " ";
			cout << "\n";
		    }
		}
		
		
	}
	return 0;
}
// } Driver Code Ends