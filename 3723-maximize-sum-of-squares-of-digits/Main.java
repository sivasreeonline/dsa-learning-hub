public class Main
{
    public static String maxSumOfSquares(int num, int sum)
    {
        // TODO 1: Check whether the requested digit sum is possible.
        // Each digit can be at most 9, so num digits can sum to at most 9 * num.
        // Hint: If sum is greater than this maximum, return an empty string.

        StringBuilder result = new StringBuilder();

        // TODO 2: Build the number by choosing the largest possible digit first.
        // Hint: While sum is greater than 0:
        //   - Choose the smaller of 9 and sum.
        //   - Append that digit to result.
        //   - Subtract the digit from sum.
        //   - Decrease num because one digit has been used.

        // TODO 3: Append zeroes until result contains the required number of digits.
        // Hint: While num is greater than 0, append '0' and decrease num.

        return result.toString();
    }

    public static void main(String[] args)
    {
        int num = 2;
        int sum = 3;

        String answer = maxSumOfSquares(num, sum);
        System.out.println("Answer: \"" + answer + "\"");
    }
}
