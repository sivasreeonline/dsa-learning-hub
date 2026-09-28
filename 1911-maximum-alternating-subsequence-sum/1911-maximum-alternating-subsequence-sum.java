class Solution
{
    public long maxAlternatingSum(int[] nums)
    {
        long even = 0;
        long odd = 0;

        for (int num : nums)
        {
            long nextEven = Math.max(even, odd + num);
            long nextOdd = Math.max(odd, even - num);

            even = nextEven;
            odd = nextOdd;
        }

        return even;
    }
}