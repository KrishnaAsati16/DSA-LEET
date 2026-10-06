// class Solution {
//     public int numSubmat(int[][] mat){
//      int count =0;
//           for(int i=0; i<mat.length;i++){
//               for(int j=0; j<mat[0].length;j++){
//                   if(i!=0 && j!=0){
//                       if(mat[i][j]==1){
//                           mat[i][j] += Math.min(mat[i-1][j],Math.min(mat[i-1][j-1],mat[i][j-1]));
//                       }
//                   }
//                   count+=mat[i][j];
//               }
//           }
//           return count;

//       }
// }              

// ------------------------------------------------wrong answer ---------------------------------------------------------------------

class Solution {
    public int numSubmat(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        int count = 0;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 1) {

                    if (j == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = dp[i][j - 1] + 1;

                    int min = dp[i][j];

                    for (int k = i; k >= 0 && min > 0; k--) {

                        min = Math.min(min, dp[k][j]);

                        count += min;
                    }
                }
            }
        }

        return count;
    }
}