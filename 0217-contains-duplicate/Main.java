import java.util.HashSet;

public class Main {

    public static boolean containsDuplicate(int[] nums) {

        // TODO 1: Create a HashSet to remember numbers
        // that have already been seen.
        // Hint: HashSet stores unique values and supports fast lookup.

        // TODO 2: Traverse the array.
        // For every number, check whether it has already been seen.

        // TODO 3: If the number is already in the set, return true.
        // Example: [1, 2, 3, 1] -> the second 1 is a duplicate.

        // TODO 4: If the number is not present, add it to the set.
        // Hint: set.add(number);

        // TODO 5: If the entire array is processed without a duplicate,
        // return false.

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};

        boolean result = containsDuplicate(nums);

        System.out.println("Contains Duplicate: " + result);
    }
}
