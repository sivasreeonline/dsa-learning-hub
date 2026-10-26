class Solution
{
    private int m;
    private int n;
    private boolean[][] visited;

    private final int[][] directions =
    {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int countIslands(int[][] grid, int k)
    {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        int count = 0;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] > 0 && !visited[i][j])
                {
                    long total = dfs(grid, i, j);

                    if (total % k == 0)
                    {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long dfs(int[][] grid, int row, int col)
    {
        if (row < 0 || row >= m ||
            col < 0 || col >= n ||
            grid[row][col] == 0 ||
            visited[row][col])
        {
            return 0;
        }

        visited[row][col] = true;

        long total = grid[row][col];

        for (int[] direction : directions)
        {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            total += dfs(grid, nextRow, nextCol);
        }

        return total;
    }
}