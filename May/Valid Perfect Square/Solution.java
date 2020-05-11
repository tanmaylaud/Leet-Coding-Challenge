class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2)
            return true;
        int L = 2;
        int R = num;
        long square;
        int mid;
        while (L <= R) {
            mid = (L + R) / 2;
            square = (long) mid * mid;
            if ((int) square == num)
                return true;
            else if (square > num) {
                R = mid - 1;
            } else
                L = mid + 1;
        }
        return false;
    }

}