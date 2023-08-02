//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int shortestDistance(int N, int M, vector<vector<int>> A, int X, int Y) {
        // code here
        if(A[0][0]==0) return -1; 
        int cnt=0;
        int d[5]={-1,0,1,0,-1};
        queue<pair<int,int>> q;
        q.push({0,0});
              A[0][0]=0;
        while(q.size()>0)
        {
            int n=q.size();
            for(int i=0;i<n;i++)
            {
                int u=q.front().first, v=q.front().second;
                q.pop();
                if(X==u && Y==v) return cnt;
                for(int i=0;i<4;i++)
                {
                    int nx=u+d[i] , ny=v+d[i+1];
                    if(nx>=0 && nx<N && ny>=0 && ny<M && A[nx][ny]==1)
                    {
                        A[nx][ny]=0;
                        q.push({nx,ny});
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, M, x, y;
        cin >> N >> M;
        vector<vector<int>> v(N, vector<int>(M));
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) cin >> v[i][j];
        cin >> x >> y;
        Solution ob;
        cout << ob.shortestDistance(N, M, v, x, y) << "\n";
    }
}
// } Driver Code Ends