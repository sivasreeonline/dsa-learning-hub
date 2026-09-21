class Solution 
{
    public long[] resultArray(int[] nums, int k) 
    {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) 
        {
            long[] next = new long[k];

            int remainder = num % k;
            next[remainder]++;

            for (int r = 0; r < k; r++) 
            {
                if (dp[r] > 0) 
                {
                    int newRemainder = (int)((r * 1L * num) % k);
                    next[newRemainder] += dp[r];
                }
            }
            for (int r = 0; r < k; r++) 
            {
                dp[r] = next[r];
                result[r] += next[r];
            }
        }
        return result;
    }
}