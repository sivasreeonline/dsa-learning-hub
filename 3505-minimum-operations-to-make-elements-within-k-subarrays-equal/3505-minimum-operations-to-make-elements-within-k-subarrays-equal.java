import java.util.TreeMap;

class Solution
{
    class MedianWindow
    {
        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();

        long lowSum = 0;
        long highSum = 0;

        int lowSize = 0;
        int highSize = 0;

        void add(int num)
        {
            if (low.isEmpty() || num <= low.lastKey())
            {
                low.put(num, low.getOrDefault(num, 0) + 1);
                lowSum += num;
                lowSize++;
            }
            else
            {
                high.put(num, high.getOrDefault(num, 0) + 1);
                highSum += num;
                highSize++;
            }

            rebalance();
        }

        void remove(int num)
        {
            if (low.containsKey(num))
            {
                removeValue(low, num);

                lowSum -= num;
                lowSize--;
            }
            else
            {
                removeValue(high, num);

                highSum -= num;
                highSize--;
            }

            rebalance();
        }

        void removeValue(TreeMap<Integer, Integer> map, int num)
        {
            int frequency = map.get(num);

            if (frequency == 1)
            {
                map.remove(num);
            }
            else
            {
                map.put(num, frequency - 1);
            }
        }

        void moveLowToHigh()
        {
            int num = low.lastKey();

            removeValue(low, num);

            lowSum -= num;
            lowSize--;

            high.put(num, high.getOrDefault(num, 0) + 1);

            highSum += num;
            highSize++;
        }

        void moveHighToLow()
        {
            int num = high.firstKey();

            removeValue(high, num);

            highSum -= num;
            highSize--;

            low.put(num, low.getOrDefault(num, 0) + 1);

            lowSum += num;
            lowSize++;
        }

        void rebalance()
        {
            while (lowSize > highSize + 1)
            {
                moveLowToHigh();
            }

            while (lowSize < highSize)
            {
                moveHighToLow();
            }
        }

        long getCost()
        {
            long median = low.lastKey();

            long leftCost = median * lowSize - lowSum;
            long rightCost = highSum - median * highSize;

            return leftCost + rightCost;
        }
    }

    public long minOperations(int[] nums, int x, int k)
    {
        int n = nums.length;

        // Step 1: Calculate the cost of every window of size x
        int windowCount = n - x + 1;

        long[] cost = new long[windowCount];

        MedianWindow window = new MedianWindow();

        for (int i = 0; i < n; i++)
        {
            window.add(nums[i]);

            if (i >= x)
            {
                window.remove(nums[i - x]);
            }

            if (i >= x - 1)
            {
                int start = i - x + 1;

                cost[start] = window.getCost();
            }
        }

        // Step 2: Dynamic Programming
        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];

        // Zero windows require zero operations
        // prev[i] = 0 for every i

        for (int j = 1; j <= k; j++)
        {
            for (int i = 0; i <= n; i++)
            {
                curr[i] = INF;
            }

            for (int i = 1; i <= n; i++)
            {
                // Choice 1: Skip the current element
                curr[i] = curr[i - 1];

                // Choice 2: Select a window of size x
                if (i >= x && prev[i - x] != INF)
                {
                    long take = prev[i - x] + cost[i - x];

                    curr[i] = Math.min(curr[i], take);
                }
            }

            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}