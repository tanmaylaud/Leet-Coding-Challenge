class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] lc = new int[A.length + 1][B.length + 1];

        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    lc[i + 1][j + 1] = lc[i][j] + 1;
                } else
                    lc[i + 1][j + 1] = Math.max(lc[i + 1][j], lc[i][j + 1]);
            }
        return lc[A.length][B.length];
    }
}