import java.util.*;

class Solution
{
    public int maxSum(List<Integer> nums, int k)
    {
        int[] bitCount = new int[31];
        long MOD = 1_000_000_007L;

        for (int num : nums)
        {
            for (int bit = 0; bit < 31; bit++)
            {
                if ((num & (1 << bit)) != 0)
                {
                    bitCount[bit]++;
                }
            }
        }

        long answer = 0;

        for (int i = 0; i < k; i++)
        {
            long value = 0;

            for (int bit = 0; bit < 31; bit++)
            {
                if (bitCount[bit] > 0)
                {
                    value |= (1L << bit);
                    bitCount[bit]--;
                }
            }

            answer = (answer + value * value) % MOD;
        }

        return (int) answer;
    }
}