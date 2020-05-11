class Solution {
    short[] dict = new short[26];

    public int firstUniqChar(String s) {
        int len = s.length();
        int i = 0;
        for (i = 0; i < len; i++) {

            dict[s.charAt(i) - 97] += 1;
        }

        for (i = 0; i < len; i++) {
            if (dict[s.charAt(i) - 97] == 1)
                return i;
        }

        return -1;

    }
}