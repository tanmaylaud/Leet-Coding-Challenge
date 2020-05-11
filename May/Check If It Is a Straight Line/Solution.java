class Solution {
    public boolean checkStraightLine(int[][] c) {
        if (c.length == 2)
            return true;

        int x1 = c[0][0];
        int y1 = c[0][1];
        int x2 = c[1][0];
        int y2 = c[1][1];

        for (int i = 2; i < c.length; i++) {
            if ((x1 - x2) * (y2 - c[i][1]) + (y2 - y1) * (x2 - c[i][0]) != 0)
                return false;
        }
        return true;
    }
}