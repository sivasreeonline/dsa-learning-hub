public class Main
{
    public static int climbStairs(int n)
    {
        if (n <= 2)
        {
            return n;
        }

        // TODO 1: Initialize the number of ways for step 1 and step 2.
        int twoStepsBack = 1;
        int oneStepBack = 2;

        for (int step = 3; step <= n; step++)
        {
            // TODO 2: The current step can be reached from:
            // - one step below, or
            // - two steps below.
            // Add those two counts.
            int current = 0;

            // TODO 3: Shift the previous values forward.
            twoStepsBack = oneStepBack;
            oneStepBack = current;
        }

        return oneStepBack;
    }

    public static void main(String[] args)
    {
        int n = 5;
        System.out.println("Ways: " + climbStairs(n));
        // Expected: 8
    }
}
