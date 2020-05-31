class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0)
            return Math.max(word1.length(), word2.length());
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int[][] dp = new int[w1.length + 1][w2.length + 1];

        for (int i = 0; i <= w1.length; i++) {
            for (int j = 0; j <= w2.length; j++) {

                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                // System.out.print(dp[i][j]+" ");
            }
            // System.out.println();
        }
        return dp[w1.length][w2.length];
    }
}