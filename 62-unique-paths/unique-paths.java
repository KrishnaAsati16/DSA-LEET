// class Solution {
//     public int uniquePaths(int m, int n) {
//          int N = m + n - 2;
//         int r = m - 1;
        
//         long res = 1;
//         for (int i = 1; i <= r; i++) {
//             res = res * (N - r + i) / i;
//         }
        
//         return (int) res;
//     }
// }



// using Dp -------------------->

// class Solution {
//      static int[][] dp;
//      public int uniquePaths(int m, int n) {
//          dp = new int [m][n];   // rows -> 0 to m, cols-> 0 to n
//          return paths(m-1,n-1);
//      }
//      public int paths(int m, int n){
//          if(m==0 || n==0) return 1;
//          if(dp[m][n]!=0) return dp[m][n];
//          return dp[m][n] = paths(m-1,n) + paths(m,n-1);
//      }
// }


class Solution {
    public int uniquePaths(int m, int n) {
               int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}