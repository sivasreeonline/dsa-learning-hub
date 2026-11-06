import java.util.Arrays;

class Solution
{
    public int[] countServers(int n, int[][] logs, int x, int[] queries)
    {
        // Sort logs by request time
        Arrays.sort(logs, (a, b) ->
        {
            return Integer.compare(a[1], b[1]);
        });

        int q = queries.length;

        // Store original query indices
        Integer[] indices = new Integer[q];

        for (int i = 0; i < q; i++)
        {
            indices[i] = i;
        }

        // Sort indices based on query times
        Arrays.sort(indices, (a, b) ->
        {
            return Integer.compare(queries[a], queries[b]);
        });

        int[] answer = new int[q];

        int[] activeServers = new int[n + 1];

        int left = 0;
        int right = 0;

        int activeCount = 0;

        // Process queries in sorted order
        for (int index : indices)
        {
            int queryTime = queries[index];
            int startTime = queryTime - x;

            // Add logs entering the window
            while (right < logs.length &&
                   logs[right][1] <= queryTime)
            {
                int serverId = logs[right][0];

                if (activeServers[serverId] == 0)
                {
                    activeCount++;
                }

                activeServers[serverId]++;
                right++;
            }

            // Remove logs leaving the window
            while (left < right &&
                   logs[left][1] < startTime)
            {
                int serverId = logs[left][0];

                activeServers[serverId]--;

                if (activeServers[serverId] == 0)
                {
                    activeCount--;
                }

                left++;
            }

            answer[index] = n - activeCount;
        }

        return answer;
    }
}