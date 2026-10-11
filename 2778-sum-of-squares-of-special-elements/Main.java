public class Main
{
    public static int sumOfSquares(int[] nums)
    {
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++)
        {
            // TODO 1: Convert the 0-based index to 1-based.
            int index = i + 1;

            // TODO 2: Check whether this index divides n.
            if (n % index == 0)
            {
                // TODO 3: Add the square of this special element.
                sum += nums[i] * nums[i];
            }
        }

        return sum;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3, 4};
        System.out.println("Sum of squares: " + sumOfSquares(nums));
    }
}
