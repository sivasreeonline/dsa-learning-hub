public class Main
{
    public static void moveZeroes(int[] nums)
    {
        int left = 0;
        int right = 0;

        while (right < nums.length)
        {
            if (nums[right] != 0)
            {
                // TODO 1: Swap the element at right
                // with the element at left.
                //
                // left represents the position where
                // the next non-zero element should go.

                // TODO 2: Move left forward after
                // placing a non-zero element.
                
            }

            // TODO 3: Move right forward after
            // checking the current element.
            
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);

        System.out.print("Output: [");

        for (int i = 0; i < nums.length; i++)
        {
            System.out.print(nums[i]);

            if (i < nums.length - 1)
            {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}
