class Solution
{
    public int closedIsland(int[][] grid)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                if (grid[row][col] == 0)
                {
                    if (dfs(grid, row, col))
                    {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid, int row, int col)
    {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols)
        {
            return false;
        }

        if (grid[row][col] == 1)
        {
            return true;
        }

        grid[row][col] = 1;

        boolean up = dfs(grid, row - 1, col);
        boolean down = dfs(grid, row + 1, col);
        boolean left = dfs(grid, row, col - 1);
        boolean right = dfs(grid, row, col + 1);

        return up && down && left && right;
    }
}