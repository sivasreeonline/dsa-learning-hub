import java.util.*;

class Solution
{
    public List<Integer> busiestServers(int k, int[] arrival, int[] load)
    {
        // Stores currently available server IDs in sorted order
        TreeSet<Integer> available = new TreeSet<>();

        // Stores [finishTime, serverId]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        // Initially, all servers are available
        for (int i = 0; i < k; i++)
        {
            available.add(i);
        }

        // Number of requests handled by each server
        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++)
        {
            // Step 1: Release all servers that have completed their tasks
            while (!busy.isEmpty() &&
                   busy.peek()[0] <= arrival[i])
            {
                long[] completed = busy.poll();

                int serverId = (int) completed[1];

                available.add(serverId);
            }

            // If all servers are busy, drop this request
            if (available.isEmpty())
            {
                continue;
            }

            // Step 2: Find the preferred server
            int preferred = i % k;

            Integer server = available.ceiling(preferred);

            // Step 3: Wrap around if necessary
            if (server == null)
            {
                server = available.first();
            }

            // Step 4: Assign the request
            available.remove(server);

            count[server]++;

            // Calculate finishing time
            long finishTime = (long) arrival[i] + load[i];

            busy.offer(new long[]{finishTime, server});
        }

        // Step 5: Find the maximum number of handled requests
        int maxRequests = 0;

        for (int requests : count)
        {
            maxRequests = Math.max(maxRequests, requests);
        }

        // Step 6: Collect all busiest servers
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < k; i++)
        {
            if (count[i] == maxRequests)
            {
                answer.add(i);
            }
        }

        return answer;
    }
}