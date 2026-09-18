public class Main {

    public static boolean canConstruct(String ransomNote, String magazine) {

        // TODO 1: If ransomNote is longer than magazine,
        // return false because there are not enough characters.

        // TODO 2: Create a frequency array of size 26.
        // Hint: int[] frequency = new int[26];

        // TODO 3: Count the characters available in magazine.
        // Hint: for a character ch, use:
        // frequency[ch - 'a']++;

        // TODO 4: Traverse ransomNote and consume one occurrence
        // of each required character.
        //
        // Decrease the corresponding frequency.
        // If the frequency becomes negative, return false.

        // TODO 5: If every required character was available,
        // return true.

        return false;
    }

    public static void main(String[] args) {

        String ransomNote = "aa";
        String magazine = "aab";

        boolean result = canConstruct(ransomNote, magazine);

        System.out.println("Ransom Note: " + ransomNote);
        System.out.println("Magazine: " + magazine);
        System.out.println("Can Construct: " + result);
    }
}
