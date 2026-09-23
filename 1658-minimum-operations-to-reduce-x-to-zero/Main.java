public class Main
{
    public static int minOperations(int[] nums, int x)
    {
        // TODO 1: Calculate the total sum of nums.

        // TODO 2: Calculate:
        // target = total - x
        //
        // We want to KEEP a subarray whose sum is target.

        // TODO 3: Handle target < 0 and target == 0.

        // TODO 4: Find the LONGEST contiguous subarray
        // whose sum equals target.
        //
        // Hint: all nums[i] are positive, so use a sliding window.

        // TODO 5: Maintain left, currentSum and maxLength.
        // Expand with right.
        // If currentSum > target, move left forward.

        // TODO 6: When currentSum == target,
        // update maxLength.

        // TODO 7: Return -1 if no valid subarray exists.
        // Otherwise return:
        // nums.length - maxLength

        return -1;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;

        int result = minOperations(nums, x);

        System.out.println("Input: nums = [1, 1, 4, 2, 3]");
        System.out.println("x = " + x);
        System.out.println("Minimum Operations: " + result);
        System.out.println("Expected: 2");
    }
}
