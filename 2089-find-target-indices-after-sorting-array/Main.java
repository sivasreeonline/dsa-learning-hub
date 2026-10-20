import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static List<Integer> targetIndices(int[] nums, int target)
    {
        int smaller = 0;
        int equal = 0;

        for (int num : nums)
        {
            if (num < target)
            {
                smaller++;
            }
            else if (num == target)
            {
                equal++;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < equal; i++)
        {
            result.add(smaller + i);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 5, 2, 3};
        int target = 2;

        System.out.println(targetIndices(nums, target));
    }
}
