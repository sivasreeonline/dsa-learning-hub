
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution
{
    public int minSwaps(int[] nums)
    {
        int n = nums.length;
        int[] sorted = nums.clone();

        Arrays.sort(sorted);

        Integer[] order = new Integer[n];

        for (int i = 0; i < n; i++)
        {
            order[i] = nums[i];
        }

        Arrays.sort(order, (a, b) ->
        {
            int sumA = digitSum(a);
            int sumB = digitSum(b);

            if (sumA != sumB)
            {
                return Integer.compare(sumA, sumB);
            }

            return Integer.compare(a, b);
        });

        Map<Integer, Integer> targetIndex = new HashMap<>();

        for (int i = 0; i < n; i++)
        {
            targetIndex.put(order[i], i);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++)
        {
            if (visited[i])
            {
                continue;
            }

            int current = i;
            int cycleLength = 0;

            while (!visited[current])
            {
                visited[current] = true;
                current = targetIndex.get(nums[current]);
                cycleLength++;
            }

            if (cycleLength > 1)
            {
                swaps += cycleLength - 1;
            }
        }

        return swaps;
    }

    private int digitSum(int num)
    {
        int sum = 0;

        while (num > 0)
        {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
