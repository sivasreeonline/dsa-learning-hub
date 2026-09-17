import java.util.HashMap;

class Solution 
{

    public boolean isAnagram(String s, String t) 
    {

        if (s.length() != t.length()) 
        {
            return false;
        }

        HashMap<Character, Integer> frequency = new HashMap<>();

        for (char ch : s.toCharArray()) 
        {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) 
        {

            if (!frequency.containsKey(ch)) 
            {
                return false;
            }

            frequency.put(ch, frequency.get(ch) - 1);

            if (frequency.get(ch) == 0) 
            {
                frequency.remove(ch);
            }
        }

        return frequency.isEmpty();
    }
}