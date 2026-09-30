public class Main
{
    public static int[] maxDepthAfterSplit(String seq)
    {
        int[] answer = new int[seq.length()];
        int depth = 0;

        for (int i = 0; i < seq.length(); i++)
        {
            if (seq.charAt(i) == '(')
            {
                // TODO 1: Assign the opening parenthesis using
                // the current depth parity: depth % 2.

                // TODO 2: Increase depth.
            }
            else
            {
                // TODO 3: Decrease depth first.

                // TODO 4: Assign the closing parenthesis using
                // the new depth parity.
            }
        }

        return answer;
    }

    public static void main(String[] args)
    {
        String seq = "(()())";
        int[] answer = maxDepthAfterSplit(seq);

        System.out.print("Answer: [");
        for (int i = 0; i < answer.length; i++)
        {
            System.out.print(answer[i]);
            if (i < answer.length - 1)
            {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        // One valid answer: [0, 1, 1, 1, 1, 0]
    }
}
