public class Main
{
    public static int smallestIndex(int[] nums)
    {
        // TODO 1: Traverse from left to right.
        // We want the smallest valid index.

        // TODO 2: For each nums[i], calculate its digit sum.
        // Hint:
        // last digit = num % 10
        // remove last digit = num / 10

        // TODO 3: If digitSum == i, return i immediately.

        // TODO 4: If no index matches, return -1.

        return -1;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 3, 2};

        int result = smallestIndex(nums);

        System.out.println("Input: [1, 3, 2]");
        System.out.println("Smallest Index: " + result);
        System.out.println("Expected: 2");
    }
}
