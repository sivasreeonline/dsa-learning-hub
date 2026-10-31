class Solution
{
    private static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;

        int[][] fromLeft = new int[m][n];
        int[][] fromAbove = new int[m][n];

        fromLeft[0][0] = 1;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                int leftWays = fromLeft[i][j];
                int aboveWays = fromAbove[i][j];

                if (grid[i][j] == 1)
                {
                    // Entering a mirror from the left reflects downward.
                    if (leftWays != 0 && i + 1 < m)
                    {
                        fromAbove[i + 1][j] =
                            (int) ((fromAbove[i + 1][j]
                            + (long) leftWays) % MOD);
                    }

                    // Entering a mirror from above reflects rightward.
                    if (aboveWays != 0 && j + 1 < n)
                    {
                        fromLeft[i][j + 1] =
                            (int) ((fromLeft[i][j + 1]
                            + (long) aboveWays) % MOD);
                    }
                }
                else
                {
                    int ways = (int)
                        (((long) leftWays + aboveWays) % MOD);

                    // Move right.
                    if (ways != 0 && j + 1 < n)
                    {
                        fromLeft[i][j + 1] =
                            (int) ((fromLeft[i][j + 1]
                            + (long) ways) % MOD);
                    }

                    // Move down.
                    if (ways != 0 && i + 1 < m)
                    {
                        fromAbove[i + 1][j] =
                            (int) ((fromAbove[i + 1][j]
                            + (long) ways) % MOD);
                    }
                }
            }
        }

        return (int) (((long) fromLeft[m - 1][n - 1]
                    + fromAbove[m - 1][n - 1]) % MOD);
    }
}