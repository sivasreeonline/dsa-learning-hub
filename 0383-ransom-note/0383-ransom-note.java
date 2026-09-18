class Solution 
{

    public boolean canConstruct(String ransomNote, String magazine) 
    {

        if (ransomNote.length() > magazine.length()) 
        {
            return false;
        }

        int[] frequency = new int[26];

        for (char ch : magazine.toCharArray()) 
        {
            frequency[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) 
        {

            frequency[ch - 'a']--;

            if (frequency[ch - 'a'] < 0) 
            {
                return false;
            }
        }

        return true;
    }
}