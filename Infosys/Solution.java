package LEETCODE.Infosys;

import java.util.Arrays;

public class Solution {
    static final int MOD = 10000000;

    public static int maxSum(int N, int X, int Y, int Z, int[] A, int[] B) {
        // Initialize a 4D DP array with very negative values
        int[][][][] dp = new int[N + 1][X + 1][Y + 1][Z + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= X; j++) {
                for (int k = 0; k <= Y; k++) {
                    Arrays.fill(dp[i][j][k], Integer.MIN_VALUE);
                }
            }
        }

        // Base case: starting point, no operations performed
        dp[0][X][Y][Z] = 0;

        // Iterate over each operation
        for (int i = 1; i <= N; i++) {
            for (int x = 0; x <= X; x++) {
                for (int y = 0; y <= Y; y++) {
                    for (int z = 0; z <= Z; z++) {
                        if (dp[i - 1][x][y][z] != Integer.MIN_VALUE) {
                            // Option 1: Subtract B[i-1] from sum
                            dp[i][x][y][z] = Math.max(dp[i][x][y][z], dp[i - 1][x][y][z] - B[i - 1]);

                            // Option 2: Decrease X and Y, then add A[i-1] * (x-1) * (y-1) * z to sum
                            if (x > 0 && y > 0) {
                                dp[i][x - 1][y - 1][z] = Math.max(dp[i][x - 1][y - 1][z],
                                        dp[i - 1][x][y][z] + A[i - 1] * (x - 1) * (y - 1) * z);
                            }

                            // Option 3: Decrease Y and Z, then add A[i-1] * x * (y-1) * (z-1) to sum
                            if (y > 0 && z > 0) {
                                dp[i][x][y - 1][z - 1] = Math.max(dp[i][x][y - 1][z - 1],
                                        dp[i - 1][x][y][z] + A[i - 1] * x * (y - 1) * (z - 1));
                            }
                        }
                    }
                }
            }
        }

        // Find the maximum sum achievable after N operations
        int result = Integer.MIN_VALUE;
        for (int x = 0; x <= X; x++) {
            for (int y = 0; y <= Y; y++) {
                for (int z = 0; z <= Z; z++) {
                    result = Math.max(result, dp[N][x][y][z]);
                }
            }
        }

        return result % MOD;
    }

    public static void main(String[] args) {
        int N = 2;
        int X = 10;
        int Y = 11;
        int Z = 11;
        int[] A = {1,10};
        int[] B = {10,0};

        System.out.println(maxSum(N, X, Y, Z, A, B));
    }
}
