import java.util.Arrays;

class Solution
{
    public long maxAlternatingSum(int[] nums)
    {
        long[] squares = new long[nums.length];

        for (int i = 0; i < nums.length; i++)
        {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        long score = 0;
        int left = 0;
        int right = squares.length - 1;

        while (left <= right)
        {
            score += squares[right--];

            if (left <= right)
            {
                score -= squares[left++];
            }
        }

        return score;
    }
}