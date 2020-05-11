class Solution {
    public int[] charDict = new int[26];

    public boolean canConstruct(String ransomNote, String magazine) {

        char[] ransomChars = ransomNote.toCharArray();
        char[] magChars = magazine.toCharArray();

        for (int i = 0; i < magChars.length; i++) {
            charDict[magChars[i] - 'a']++;
        }

        for (int i = 0; i < ransomChars.length; i++) {
            charDict[ransomChars[i] - 'a']--;
            if (charDict[ransomChars[i] - 'a'] < 0)
                return false;
        }

        return true;
    }

}