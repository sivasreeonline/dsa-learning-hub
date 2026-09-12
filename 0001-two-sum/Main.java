import java.util.HashMap;

public class Main {

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // TODO 1: Find the complement.
            // The complement is the number needed to reach the target.
            // Example: target = 9, current number = 2
            // Complement = 9 - 2 = 7
            int complement = target - nums[i];

            // TODO 2: Check if the complement is already in the map.
            // If it is present, we found the two numbers.
            // Return the index stored in the map and the current index.
            //
            // Hint:
            // Check whether the map contains the complement.
            // Example: if complement = 7 and 7 is already in the map,
            // get the index of 7 from the map.

            // TODO 3: Store the current number and its index in the map.
            // Example: if nums[i] = 2 and i = 0,
            // store 2 as the key and 0 as its value.
        }

        // No pair found
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println("Answer: [" + result[0] + ", " + result[1] + "]");
    }
}
