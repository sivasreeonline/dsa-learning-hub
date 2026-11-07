import java.util.PriorityQueue;

class Solution
{
    public int[] assignTasks(int[] servers, int[] tasks)
    {
        int n = servers.length;
        int m = tasks.length;

        // Available servers: [weight, serverIndex]
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) ->
            {
                if (a[0] != b[0])
                {
                    return Integer.compare(a[0], b[0]);
                }

                return Integer.compare(a[1], b[1]);
            }
        );

        // Busy servers: [finishTime, serverIndex]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) ->
            {
                if (a[0] != b[0])
                {
                    return Long.compare(a[0], b[0]);
                }

                return Long.compare(a[1], b[1]);
            }
        );

        // Initially, all servers are available
        for (int i = 0; i < n; i++)
        {
            available.offer(new int[]{servers[i], i});
        }

        int[] answer = new int[m];

        long time = 0;

        for (int j = 0; j < m; j++)
        {
            // Current time cannot be earlier than task arrival
            time = Math.max(time, j);

            // Release all servers that have completed their tasks
            while (!busy.isEmpty() && busy.peek()[0] <= time)
            {
                long[] server = busy.poll();

                int serverIndex = (int) server[1];

                available.offer(
                    new int[]{servers[serverIndex], serverIndex}
                );
            }

            // If no server is available, wait for the earliest one
            if (available.isEmpty())
            {
                time = busy.peek()[0];

                // Release all servers finishing at this time
                while (!busy.isEmpty() && busy.peek()[0] <= time)
                {
                    long[] server = busy.poll();

                    int serverIndex = (int) server[1];

                    available.offer(
                        new int[]{servers[serverIndex], serverIndex}
                    );
                }
            }

            // Assign the task to the best available server
            int[] server = available.poll();

            int serverIndex = server[1];

            answer[j] = serverIndex;

            // Calculate when this server becomes free
            long finishTime = time + tasks[j];

            busy.offer(new long[]{finishTime, serverIndex});
        }

        return answer;
    }
}