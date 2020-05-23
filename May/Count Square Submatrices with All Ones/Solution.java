class Solution {
    public int countSquares(int[][] matrix) {
        int count = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 1)
                count++;
        }
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 1)
                count++;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    int squares = Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]) + 1;
                    count += squares;
                    matrix[i][j] = squares;
                }
            }

        }

        return count;
    }
}