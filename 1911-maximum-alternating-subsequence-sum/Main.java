public class Main
{
    public static long maxAlternatingSum(int[] nums)
    {
        // even: best sum where the next selected number is added.
        // odd: best sum where the next selected number is subtracted.
        long even = 0;
        long odd = 0;

        for (int num : nums)
        {
            // TODO 1: Either skip num (keep even), or select it
            // as a positive term (odd + num).
            long nextEven = even;

            // TODO 2: Either skip num (keep odd), or select it
            // as a negative term (even - num).
            long nextOdd = odd;

            // TODO 3: Update both states after calculating them.
            even = nextEven;
            odd = nextOdd;
        }

        return even;
    }

    public static void main(String[] args)
    {
        int[] nums = {4, 2, 5, 3};
        System.out.println("Maximum alternating sum: " + maxAlternatingSum(nums));
        // Expected: 7
    }
}
