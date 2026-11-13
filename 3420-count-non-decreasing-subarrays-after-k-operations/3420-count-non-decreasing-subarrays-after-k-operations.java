import java.util.*;

class Solution
{
    int n;
    int LOG;

    int[][] up;
    long[][] blockSum;

    long[] prefixSum;
    int[] nums;

    public long countNonDecreasingSubarrays(int[] nums, int k)
    {
        this.nums = nums;
        this.n = nums.length;

        // Number of binary lifting levels
        LOG = 1;

        while ((1 << LOG) <= n)
        {
            LOG++;
        }

        // Step 1: Calculate prefix sums
        prefixSum = new long[n + 1];

        for (int i = 0; i < n; i++)
        {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Step 2: Calculate next greater elements
        int[] nextGreater = new int[n];

        int[] stack = new int[n];
        int top = 0;

        for (int i = n - 1; i >= 0; i--)
        {
            while (top > 0 &&
                   nums[stack[top - 1]] <= nums[i])
            {
                top--;
            }

            nextGreater[i] = (top == 0) ? n : stack[top - 1];

            stack[top++] = i;
        }

        // Step 3: Build binary lifting tables
        up = new int[LOG][n + 1];
        blockSum = new long[LOG][n + 1];

        // Base level: one maximum block
        for (int i = 0; i < n; i++)
        {
            up[0][i] = nextGreater[i];

            blockSum[0][i] =
                (long) nums[i] * (nextGreater[i] - i);
        }

        // Sentinel position
        up[0][n] = n;
        blockSum[0][n] = 0;

        // Build higher levels
        for (int p = 1; p < LOG; p++)
        {
            for (int i = 0; i <= n; i++)
            {
                int mid = up[p - 1][i];

                up[p][i] = up[p - 1][mid];

                blockSum[p][i] =
                    blockSum[p - 1][i] +
                    blockSum[p - 1][mid];
            }
        }

        // Step 4: Sliding right endpoint + binary search
        long answer = 0;

        for (int right = 0; right < n; right++)
        {
            int low = 0;
            int high = right;

            while (low < high)
            {
                int mid = low + (high - low) / 2;

                long operations = getCost(mid, right);

                if (operations <= k)
                {
                    high = mid;
                }
                else
                {
                    low = mid + 1;
                }
            }

            // All starting positions from low to right are valid
            answer += right - low + 1;
        }

        return answer;
    }

    // Calculate minimum operations for subarray [left, right]
    long getCost(int left, int right)
    {
        long maxSum = 0;

        int current = left;

        // Jump across complete maximum blocks
        for (int p = LOG - 1; p >= 0; p--)
        {
            int next = up[p][current];

            if (next <= right)
            {
                maxSum += blockSum[p][current];

                current = next;
            }
        }

        // Add the final incomplete maximum block
        maxSum +=
            (long) nums[current] * (right - current + 1);

        // Sum of original elements in [left, right]
        long originalSum =
            prefixSum[right + 1] - prefixSum[left];

        return maxSum - originalSum;
    }
}