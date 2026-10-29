import java.util.ArrayList;
import java.util.List;

class Solution
{
    private int[][] up;
    private int[] depth;
    private int[] tin;
    private int[] tout;
    private int[] bit;
    private char[] chars;
    private int n;
    private int log;

    public List<Boolean> palindromePath(
        int n, int[][] edges, String s, String[] queries)
    {
        this.n = n;
        chars = s.toCharArray();

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
        {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        log = 1;

        while ((1 << log) <= n)
        {
            log++;
        }

        up = new int[log][n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];

        buildEulerTour(graph);
        buildLcaTable();

        bit = new int[n + 2];

        for (int u = 0; u < n; u++)
        {
            int mask = 1 << (chars[u] - 'a');
            rangeXor(tin[u], tout[u], mask);
        }

        List<Boolean> answer = new ArrayList<>();

        for (String query : queries)
        {
            String[] parts = query.split(" ");

            if (parts[0].equals("update"))
            {
                int u = Integer.parseInt(parts[1]);
                char newChar = parts[2].charAt(0);

                int oldMask = 1 << (chars[u] - 'a');
                int newMask = 1 << (newChar - 'a');

                int change = oldMask ^ newMask;

                if (change != 0)
                {
                    rangeXor(tin[u], tout[u], change);
                    chars[u] = newChar;
                }
            }
            else
            {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int ancestor = lca(u, v);

                int mask = rootMask(u)
                         ^ rootMask(v)
                         ^ (1 << (chars[ancestor] - 'a'));

                answer.add(Integer.bitCount(mask) <= 1);
            }
        }

        return answer;
    }

    private void buildEulerTour(List<Integer>[] graph)
    {
        int[] order = new int[n];
        int[] stack = new int[n];
        int[] parent = new int[n];

        int top = 0;
        int timer = 0;

        stack[top++] = 0;
        parent[0] = 0;
        up[0][0] = 0;

        while (top > 0)
        {
            int u = stack[--top];

            tin[u] = timer;
            order[timer++] = u;

            for (int v : graph[u])
            {
                if (v == parent[u])
                {
                    continue;
                }

                parent[v] = u;
                up[0][v] = u;
                depth[v] = depth[u] + 1;

                stack[top++] = v;
            }
        }

        int[] subtreeSize = new int[n];

        for (int i = 0; i < n; i++)
        {
            subtreeSize[i] = 1;
        }

        for (int i = n - 1; i > 0; i--)
        {
            int u = order[i];
            subtreeSize[parent[u]] += subtreeSize[u];
        }

        for (int u = 0; u < n; u++)
        {
            tout[u] = tin[u] + subtreeSize[u] - 1;
        }
    }

    private void buildLcaTable()
    {
        for (int j = 1; j < log; j++)
        {
            for (int u = 0; u < n; u++)
            {
                up[j][u] = up[j - 1][up[j - 1][u]];
            }
        }
    }

    private int lca(int u, int v)
    {
        if (depth[u] < depth[v])
        {
            int temp = u;
            u = v;
            v = temp;
        }

        int difference = depth[u] - depth[v];

        for (int j = 0; j < log; j++)
        {
            if ((difference & (1 << j)) != 0)
            {
                u = up[j][u];
            }
        }

        if (u == v)
        {
            return u;
        }

        for (int j = log - 1; j >= 0; j--)
        {
            if (up[j][u] != up[j][v])
            {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return up[0][u];
    }

    private void rangeXor(int left, int right, int mask)
    {
        update(left + 1, mask);
        update(right + 2, mask);
    }

    private void update(int index, int mask)
    {
        while (index <= n)
        {
            bit[index] ^= mask;
            index += index & -index;
        }
    }

    private int prefixXor(int index)
    {
        int result = 0;

        while (index > 0)
        {
            result ^= bit[index];
            index -= index & -index;
        }

        return result;
    }

    private int rootMask(int u)
    {
        return prefixXor(tin[u] + 1);
    }
}