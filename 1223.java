    Class{
           public int dieSimulator(int n, int[] rollMax) {
            int[][] dp = new int[7][n+1];
            for(int i=1; i<=6; i++) {
                dp[i][1] = 1;
            }
            
            for(int len=2; len<=n; len++) {
                for(int i=1; i<=6; i++) {
                    for(int k=1; k<=6; k++) {
                        dp[i][len] += dp[k][len-1];
                    }
                    if(len > rollMax[i-1]) {
                        dp[i][len] -= dp[i][len - rollMax[i-1]];
                    }
                }
            }
            int sum = 0;
            for(int i=1; i<=6; i++) {
                sum += dp[i][n];
            }
            return sum;
        }

    }