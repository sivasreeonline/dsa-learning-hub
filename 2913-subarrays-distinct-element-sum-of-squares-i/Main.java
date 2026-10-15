import java.util.List;
import java.util.ArrayList;

public class Main
{
    public static int sumCounts(List<Integer> nums)
    {
        int total = 0;

        // TODO 1: Start each subarray at every possible left index.
        for (int left = 0; left < nums.size(); left++)
        {
            // TODO 2: Create a set to track distinct values for this subarray.
            // Hint: HashSet<Integer> distinct = new HashSet<>();

            // TODO 3: Extend the subarray one element at a time.
            for (int right = left; right < nums.size(); right++)
            {
                // Add nums.get(right) to the set.

                // TODO 4: The distinct count is distinct.size().
                // Add its square to total.
            }
        }

        return total;
    }

    public static void main(String[] args)
    {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(1);

        System.out.println("Input: " + nums);
        System.out.println("Sum of squared distinct counts: " + sumCounts(nums));
        // Expected output: 15
    }
}
