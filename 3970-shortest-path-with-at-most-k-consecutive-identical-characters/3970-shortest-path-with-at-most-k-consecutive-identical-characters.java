import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution
{
    static class State
    {
        long cost;
        int node;
        int consecutive;

        State(long cost, int node, int consecutive)
        {
            this.cost = cost;
            this.node = node;
            this.consecutive = consecutive;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k)
    {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
        {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges)
        {
            graph[edge[0]].add(new int[] {edge[1], edge[2]});
        }

        long[][] distance = new long[n][k + 1];

        for (long[] row : distance)
        {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        PriorityQueue<State> pq = new PriorityQueue<>(
            Comparator.comparingLong(state -> state.cost)
        );

        distance[0][1] = 0;
        pq.offer(new State(0, 0, 1));

        while (!pq.isEmpty())
        {
            State current = pq.poll();

            if (current.cost != distance[current.node][current.consecutive])
            {
                continue;
            }

            if (current.node == n - 1)
            {
                return (int) current.cost;
            }

            for (int[] edge : graph[current.node])
            {
                int nextNode = edge[0];
                int weight = edge[1];
                int nextConsecutive;

                if (labels.charAt(nextNode) == labels.charAt(current.node))
                {
                    if (current.consecutive == k)
                    {
                        continue;
                    }

                    nextConsecutive = current.consecutive + 1;
                }
                else
                {
                    nextConsecutive = 1;
                }

                long nextCost = current.cost + weight;

                if (nextCost < distance[nextNode][nextConsecutive])
                {
                    distance[nextNode][nextConsecutive] = nextCost;

                    pq.offer(
                        new State(nextCost, nextNode, nextConsecutive)
                    );
                }
            }
        }

        return -1;
    }
}