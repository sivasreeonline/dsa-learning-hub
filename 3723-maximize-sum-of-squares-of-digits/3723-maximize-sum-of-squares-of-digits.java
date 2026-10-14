class Solution
{
    public String maxSumOfSquares(int num, int sum)
    {
        if (sum > 9 * num)
        {
            return "";
        }

        StringBuilder result = new StringBuilder();

        while (sum > 0)
        {
            int digit = Math.min(9, sum);

            result.append(digit);
            sum -= digit;
            num--;
        }

        while (num > 0)
        {
            result.append('0');
            num--;
        }

        return result.toString();
    }
}