public int eggDrop(int k, int n) {
        // i is eggs j is floors

        int[][] dp = new int[k+1][n+1];

        // base cases:
        for (int i = 1; i <= k; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        // if only one egg, trials is the same as num of floors
        for (int j = 1; j <= n; j++) {
            dp[1][j] = j;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    // for each floor x find max num of trials btw dropping at floor and breaking and not breaking
                    int res = 1 + Math.max(dp[i-1][x-1], dp[i][j-x]);
                    // find min result for each x to find min number of trials for eggs and floors
                    if (res < dp[i][j]) {
                        dp[i][j] = res;
                    }
                }
            }
        }
        return dp[k][n];
    }
