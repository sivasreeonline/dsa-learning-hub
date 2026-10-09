class Solution
{
    public int minInsertions(String s)
    {
        int insertions = 0;
        int need = 0;

        for (char ch : s.toCharArray())
        {
            if (ch == '(')
            {
                if (need % 2 == 1)
                {
                    insertions++;
                    need--;
                }

                need += 2;
            }
            else
            {
                need--;

                if (need < 0)
                {
                    insertions++;
                    need = 1;
                }
            }
        }

        return insertions + need;
    }
}