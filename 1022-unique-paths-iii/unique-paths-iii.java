class Solution {
    int m, n;
    int[][] grid;
    int[][][] dp;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        int sr = 0, sc = 0;
        int total = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] != -1)
                    total++;

                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
            }
        }

        dp = new int[m][n][1 << (m * n)];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        int startMask = 1 << (sr * n + sc);

        return solve(sr, sc, startMask, total);
    }

    int solve(int i, int j, int mask, int total) {

        if (grid[i][j] == 2) {
            return Integer.bitCount(mask) == total ? 1 : 0;
        }

        if (dp[i][j][mask] != -1)
            return dp[i][j][mask];

        int ans = 0;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for (int k = 0; k < 4; k++) {

            int ni = i + dr[k];
            int nj = j + dc[k];

            if (ni >= 0 && ni < m &&
                nj >= 0 && nj < n &&
                grid[ni][nj] != -1) {

                int bit = 1 << (ni * n + nj);

                if ((mask & bit) == 0) {
                    ans += solve(ni, nj, mask | bit, total);
                }
            }
        }

        return dp[i][j][mask] = ans;
    }
}