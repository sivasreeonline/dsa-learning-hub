public class Main
{
    public static long[] resultArray(int[] nums, int k)
    {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums)
        {
            long[] next = new long[k];

            // TODO 1: Start a new subarray using only the current number.
            // Hint: calculate num % k and increase that remainder's count.

            // TODO 2: Extend every subarray from the previous position.
            // dp[r] = number of previous subarrays with product % k == r.
            // New remainder = (r * num) % k.
            // Hint: loop through r = 0 to k - 1.

            // TODO 3: Update dp using next.
            // next contains all subarrays ending at the current position.

            // TODO 4: Add next counts into result.
            // result contains totals across the entire array.
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;

        long[] result = resultArray(nums, k);

        System.out.print("Result: [");

        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i]);

            if (i < result.length - 1)
            {
                System.out.print(", ");
            }
        }

        System.out.println("]");
        System.out.println("Expected: [9, 2, 4]");
    }
}
