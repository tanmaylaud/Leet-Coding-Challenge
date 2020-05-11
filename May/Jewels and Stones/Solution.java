class Solution {
    public int numJewelsInStones(String J, String S) {

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            count += isJewel(J, S.charAt(i));
        }
        return count;
    }

    public int isJewel(String J, char s) {
        for (int j = 0; j < J.length(); j++) {
            if (s == (J.charAt(j)))
                return 1;
        }
        return 0;
    }
}